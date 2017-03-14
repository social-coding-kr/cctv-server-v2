package com.socialcoding.interfaces.api.v2.cctv.controller;

import com.socialcoding.interfaces.api.v1.cctv.dto.CctvDto;
import com.socialcoding.interfaces.api.v2.cctv.service.CctvFacadeServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CctvControllerV2 {

	private final CctvFacadeServiceV2 cctvFacadeService;

	@Autowired
	public CctvControllerV2(CctvFacadeServiceV2 cctvFacadeServiceV2) {
		this.cctvFacadeService = cctvFacadeServiceV2;
	}

	@GetMapping("/v2/cctv/{name}")
	public CctvDto get(@PathVariable String name) {
		return cctvFacadeService.getCctv(name);
	}

}
