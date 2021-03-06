package com.socialcoding.interfaces.api.v2.map.controller;

import com.socialcoding.interfaces.api.v2.map.dto.MapBoundSearchForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapCountDto;
import com.socialcoding.interfaces.api.v2.map.dto.MapDto;
import com.socialcoding.interfaces.api.v2.map.service.MapFacadeServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MapControllerV2 {

	private final MapFacadeServiceV2 mapFacadeService;

	@Autowired
	public MapControllerV2(MapFacadeServiceV2 mapFacadeServiceV2) {
		this.mapFacadeService = mapFacadeServiceV2;
	}

	@GetMapping("/api/v2/map")
	public MapDto map(@Valid MapBoundSearchForm searchForm) {
		return mapFacadeService.listCctvBetween(searchForm);
	}

	@GetMapping("/api/v2/map/cctvs/counts")
	public MapCountDto countCctvs(@Valid MapBoundSearchForm searchForm) {
		return mapFacadeService.countCctvBetween(searchForm);
	}

}
