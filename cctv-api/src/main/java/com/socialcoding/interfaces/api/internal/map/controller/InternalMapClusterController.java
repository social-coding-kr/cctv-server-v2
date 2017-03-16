package com.socialcoding.interfaces.api.internal.map.controller;

import com.socialcoding.interfaces.api.internal.map.dto.MapClusterRegisterFileForm;
import com.socialcoding.interfaces.api.internal.map.dto.MapClusterRegisterForm;
import com.socialcoding.interfaces.api.internal.map.service.InternalMapClusterFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternalMapClusterController {

	private final InternalMapClusterFacadeService internalMapClusterFacadeService;

	@Autowired
	public InternalMapClusterController(InternalMapClusterFacadeService internalMapClusterFacadeService) {
		this.internalMapClusterFacadeService = internalMapClusterFacadeService;
	}

	@PostMapping("/api/internal/map/clusters")
	public void register(@RequestBody MapClusterRegisterForm registerForm) {
		internalMapClusterFacadeService.register(registerForm);
	}

	@PostMapping("/api/internal/map/clusters/csv")
	public void register(@RequestBody MapClusterRegisterFileForm registerForm) {
		internalMapClusterFacadeService.register(registerForm);
	}

}
