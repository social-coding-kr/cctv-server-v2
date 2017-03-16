package com.socialcoding.interfaces.api.internal.cctv.controller;

import com.socialcoding.interfaces.api.internal.cctv.dto.OfficialCctvRegisterFileForm;
import com.socialcoding.interfaces.api.internal.cctv.service.InternalCctvFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternalCctvController {

	@Autowired
	private InternalCctvFacadeService internalCctvFacadeService;

	@PostMapping("/api/internal/cctvs/official")
	public void registerFromFile(@RequestBody OfficialCctvRegisterFileForm registerForm) {
		internalCctvFacadeService.register(registerForm);
	}

}
