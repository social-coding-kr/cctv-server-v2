package com.socialcoding.interfaces.api.v2.map.controller;

import com.socialcoding.interfaces.api.v2.map.service.MapClusterFacadeServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapClusterControllerV2 {

	@Autowired
	private MapClusterFacadeServiceV2 mapClusterFacadeServiceV2;

	@PostMapping("/v2/map/clusters")
	public void register() {
//		mapClusterFacadeServiceV2.register
	}

}
