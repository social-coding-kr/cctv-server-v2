package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.entity.UserCctvEntity;
import com.socialcoding.domain.cctv.form.CctvClusterConditions;
import com.socialcoding.domain.cctv.form.CctvInsertForm;
import com.socialcoding.domain.cctv.form.CctvSearchConditions;
import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.map.model.CctvMap;
import com.socialcoding.domain.map.model.ClusteredCctv;
import com.socialcoding.interfaces.api.v1.cctv.dto.request.CctvRegistrationForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Service
public class CctvFacadeService {

	private final CctvQueryService cctvQueryService;

	private final CctvCommandService cctvCommandService;

	private final CctvNameService cctvNameService;

	private final CctvAddressService cctvAddressService;

	private final CctvImageService cctvImageService;


	@Autowired
	public CctvFacadeService(CctvQueryService cctvQueryService, CctvCommandService cctvCommandService, CctvNameService cctvNameService,
		CctvAddressService cctvAddressService, CctvImageService cctvImageService) {

		this.cctvQueryService = cctvQueryService;
		this.cctvCommandService = cctvCommandService;
		this.cctvNameService = cctvNameService;
		this.cctvAddressService = cctvAddressService;
		this.cctvImageService = cctvImageService;
	}

	public Mono<Cctv> getCctv(Long id) {
		return cctvQueryService.findById(id)
			.otherwiseIfEmpty(Mono.error(new IllegalArgumentException("Fail to find cctv: " + id)))
			.doOnError(Exceptions::propagate)
			.map(Cctv::fromEntity);
	}

	public Mono<Cctv> getCctv(String name) {
		return cctvQueryService.findByName(name)
			.otherwiseIfEmpty(Mono.error(new IllegalArgumentException("Fail to find cctv: " + name)))
			.doOnError(Exceptions::propagate)
			.map(Cctv::fromEntity);
	}

	public Flux<Cctv> listCctvs(CctvSearchConditions conditions) {
		return cctvQueryService.findAll(conditions.toPredicate())
			.map(Cctv::fromEntity);
	}

	public Flux<ClusteredCctv> getClusteredCctvs(CctvClusterConditions conditions) {
		return cctvQueryService.groupByClusterId(conditions.toPredicate());
	}

	public Mono<CctvMap> getCctvMap(CctvSearchConditions conditions) {
		Objects.requireNonNull(conditions.getMapBound());

		return listCctvs(conditions)
			.collectList()
			.map(cctvs -> CctvMap.of(cctvs, conditions.getType(), conditions.getMapBound()));
	}

	public Mono<Long> countCctvs(CctvSearchConditions conditions) {
		return cctvQueryService.count(conditions.toPredicate());
	}

	public void insert(CctvInsertForm insertForm) {
		CctvEntity entity = insertForm.toEntity();
		cctvCommandService.insert(entity)
			.block();
	}

	//FIXME 위의 insert method랑 함께 고치기
	public Cctv registerUserCctv(CctvRegistrationForm form, MultipartFile cctvImage, MultipartFile noticeImage) {
		UserCctvEntity cctv = new UserCctvEntity();
		Geolocation location = Geolocation.of(form.getLatitude(), form.getLongitude());
		String name = cctvNameService.generateName(location);
		cctv.setName(name);
		cctv.setLocation(location.toEntity());
		cctv.setAddress(cctvAddressService.getAddress(location));
		cctv.setCctvImage(cctvImageService.save(cctvImage));
		cctv.setNoticeImage(cctvImageService.save(noticeImage));

		log.debug("cctv name: {}", name);

//		CctvEntity saved = cctvCommandService.insert(cctv);
//		return Cctv.fromEntity(saved);
		return null;
	}

}
