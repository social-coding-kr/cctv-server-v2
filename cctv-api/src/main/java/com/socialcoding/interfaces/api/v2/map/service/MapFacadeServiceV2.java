package com.socialcoding.interfaces.api.v2.map.service;

import com.socialcoding.domain.cctv.form.CctvSearchConditions;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.interfaces.api.v2.map.dto.MapBoundSearchForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapCctvDto;
import com.socialcoding.interfaces.api.v2.map.dto.MapCountDto;
import com.socialcoding.interfaces.api.v2.map.dto.MapDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

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
		return cctvFacadeService.listCctvs(conditions)
			.map(MapCctvDto::from)
			.collectList()
			.map(MapDto::with)
			.block();
	}

	public MapCountDto countCctvBetween(MapBoundSearchForm searchForm) {
		CctvSearchConditions conditions = new CctvSearchConditions();
		conditions.setMapBound(searchForm.toMapBound());
		return cctvFacadeService.countCctvs(conditions)
			.otherwiseIfEmpty(Mono.error(new IllegalArgumentException("Fail to get cctv: " + searchForm)))
			.doOnError(Exceptions::propagate)
			.map(MapCountDto::with)
			.block();
	}
}
