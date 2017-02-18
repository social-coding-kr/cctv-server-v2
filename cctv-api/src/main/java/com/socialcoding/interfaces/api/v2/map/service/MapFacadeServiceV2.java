package com.socialcoding.interfaces.api.v2.map.service;

import com.socialcoding.domain.cctv.model.CctvSearchConditions;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.interfaces.api.v2.map.dto.MapBoundSearchForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapCountDto;
import com.socialcoding.interfaces.api.v2.map.dto.MapCctvDto;
import com.socialcoding.interfaces.api.v2.map.dto.MapDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MapFacadeServiceV2 {

	private final CctvFacadeService cctvFacadeService;

	@Autowired
	public MapFacadeServiceV2(CctvFacadeService cctvFacadeService) {
		this.cctvFacadeService = cctvFacadeService;
	}

	public MapDto listCctvBetween(MapBoundSearchForm searchForm) {
		CctvSearchConditions conditions = new CctvSearchConditions();
		conditions.setMapBound(searchForm.toMapBound());
		List<MapCctvDto> cctvs = cctvFacadeService.listCctvs(conditions).stream()
			.map(MapCctvDto::from)
			.collect(Collectors.toList());
		return MapDto.with(cctvs);
	}

	public MapCountDto countCctvBetween(MapBoundSearchForm searchForm) {
		CctvSearchConditions conditions = new CctvSearchConditions();
		conditions.setMapBound(searchForm.toMapBound());
		return Optional.of(cctvFacadeService.countCctvs(conditions))
			.map(MapCountDto::with)
			.orElseThrow(() -> new IllegalArgumentException("Fail to get cctv: " + searchForm));
	}
}
