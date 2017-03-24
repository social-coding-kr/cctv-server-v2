package com.socialcoding.interfaces.api.v2.cctv.controller;

import com.socialcoding.interfaces.api.v2.cctv.dto.CctvDto;
import com.socialcoding.interfaces.api.v2.cctv.dto.UserCctvRegisterForm;
import com.socialcoding.interfaces.api.v2.cctv.service.CctvFacadeServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

	@PostMapping("/api/v2/cctvs")
	public void register(@RequestPart UserCctvRegisterForm cctv, @RequestPart MultipartFile cctvImage, @RequestPart MultipartFile noticeImage) {
		cctvFacadeService.register(cctv, cctvImage, noticeImage);
	}

}
