package com.socialcoding.interfaces.api.v2.map.controller;

import com.socialcoding.interfaces.api.v2.map.dto.MapClusterRegisterFileForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusterRegisterForm;
import com.socialcoding.interfaces.api.v2.map.service.MapClusterFacadeServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapClusterControllerV2 {

	private final MapClusterFacadeServiceV2 mapClusterFacadeServiceV2;

	@Autowired
	public MapClusterControllerV2(MapClusterFacadeServiceV2 mapClusterFacadeServiceV2) {
		this.mapClusterFacadeServiceV2 = mapClusterFacadeServiceV2;
	}

	@PostMapping("/api/v2/map/clusters")
	public void register(@RequestBody MapClusterRegisterForm registerForm) {
		mapClusterFacadeServiceV2.register(registerForm);
	}

	@PostMapping("/api/v2/map/clusters/csv")
	public void register(@RequestBody MapClusterRegisterFileForm registerForm) {
		mapClusterFacadeServiceV2.register(registerForm);
	}

}
