package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.entity.UserCctvEntity;
import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvSearchConditions;
import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.map.model.CctvMap;
import com.socialcoding.interfaces.api.v1.cctv.dto.request.CctvRegistrationForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

	public Cctv getCctv(Long id) {
		CctvEntity cctv = cctvQueryService.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Fail to find cctv: " + id));
		return Cctv.fromEntity(cctv);
	}

	public Cctv getCctv(String name) {
		CctvEntity cctv = cctvQueryService.findByName(name)
			.orElseThrow(() -> new IllegalArgumentException("Fail to find cctv: " + name));
		return Cctv.fromEntity(cctv);
	}

	public List<Cctv> listCctvs(CctvSearchConditions conditions) {
		return cctvQueryService.findAll(conditions.toPredicate()).stream()
			.map(Cctv::fromEntity)
			.collect(Collectors.toList());
	}

	public CctvMap getCctvMap(CctvSearchConditions conditions) {
		Objects.requireNonNull(conditions.getMapBound());

		List<Cctv> cctvs = listCctvs(conditions);
		return CctvMap.of(cctvs, conditions.getType(), conditions.getMapBound());
	}

	public long countCctvs(CctvSearchConditions conditions) {
		return cctvQueryService.count(conditions.toPredicate());
	}

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

		CctvEntity saved = cctvCommandService.insert(cctv);
		return Cctv.fromEntity(saved);
	}
}
