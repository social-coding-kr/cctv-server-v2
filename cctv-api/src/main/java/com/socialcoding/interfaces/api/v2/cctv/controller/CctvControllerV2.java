package com.socialcoding.interfaces.api.v2.cctv.controller;

import com.socialcoding.interfaces.api.v2.cctv.dto.CctvDto;
import com.socialcoding.interfaces.api.v2.cctv.service.CctvFacadeServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CctvControllerV2 {

	private final CctvFacadeServiceV2 cctvFacadeService;

	@Autowired
	public CctvControllerV2(CctvFacadeServiceV2 cctvFacadeServiceV2) {
		this.cctvFacadeService = cctvFacadeServiceV2;
	}

	@GetMapping("/api/v2/cctvs/{name}")
	public CctvDto get(@PathVariable String name) {
		return cctvFacadeService.getCctv(name);
	}

}
