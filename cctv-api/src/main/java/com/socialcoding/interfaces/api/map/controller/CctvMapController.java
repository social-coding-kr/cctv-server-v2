package com.socialcoding.interfaces.api.map.controller;

import com.socialcoding.interfaces.api.map.dto.MapBoundCctvDto;
import com.socialcoding.interfaces.api.map.dto.MapBoundCctvSearchForm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/map/cctvs")
public class CctvMapController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public MapBoundCctvDto getBoundedCctvs(@Valid MapBoundCctvSearchForm searchForm) {
		return null;
	}

	@RequestMapping(value = "/counts", method = RequestMethod.GET)
	public MapBoundCctvDto getBoundedCctvCounts(@Valid MapBoundCctvSearchForm searchForm) {
		return null;
	}

}
