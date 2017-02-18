package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvSearchConditions;
import com.socialcoding.domain.map.model.CctvMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CctvFacadeService {

	private final CctvQueryService cctvQueryService;

	private final CctvCommandService cctvCommandService;

	@Autowired
	public CctvFacadeService(CctvQueryService cctvQueryService, CctvCommandService cctvCommandService) {
		this.cctvQueryService = cctvQueryService;
		this.cctvCommandService = cctvCommandService;
	}

	public Cctv getCctv(Long id) {
		CctvEntity cctv = cctvQueryService.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Fail to find cctv: " + id));
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

}
