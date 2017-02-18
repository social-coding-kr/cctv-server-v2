package com.socialcoding.interfaces.api.v2.map.controller;

import com.socialcoding.interfaces.api.v2.map.dto.MapBoundSearchForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapCountDto;
import com.socialcoding.interfaces.api.v2.map.dto.MapDto;
import com.socialcoding.interfaces.api.v2.map.service.MapFacadeServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MapControllerV2 {

	private final MapFacadeServiceV2 mapFacadeService;

	@Autowired
	public MapControllerV2(MapFacadeServiceV2 mapFacadeServiceV2) {
		this.mapFacadeService = mapFacadeServiceV2;
	}

	@RequestMapping(value = "/v2/map", method = RequestMethod.GET)
	public MapDto getCctvs(@Valid MapBoundSearchForm searchForm) {
		return mapFacadeService.listCctvBetween(searchForm);
	}

	@RequestMapping(value = "/v2/map/cctvs/counts", method = RequestMethod.GET)
	public MapCountDto getCctvCounts(@Valid MapBoundSearchForm searchForm) {
		return mapFacadeService.countCctvBetween(searchForm);
	}

}
