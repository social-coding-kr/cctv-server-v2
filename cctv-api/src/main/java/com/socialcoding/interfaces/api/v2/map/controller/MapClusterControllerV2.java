package com.socialcoding.interfaces.api.v2.map.controller;

import com.socialcoding.interfaces.api.v2.map.dto.MapBoundSearchForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusteredCctvDto;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusterRegisterFileForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusterRegisterForm;
import com.socialcoding.interfaces.api.v2.map.service.MapClusterFacadeServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MapClusterControllerV2 {

	private final MapClusterFacadeServiceV2 mapClusterFacadeServiceV2;

	@Autowired
	public MapClusterControllerV2(MapClusterFacadeServiceV2 mapClusterFacadeServiceV2) {
		this.mapClusterFacadeServiceV2 = mapClusterFacadeServiceV2;
	}

	@GetMapping("/api/v2/map/clusters")
	public List<MapClusteredCctvDto> getClusteredCctvs(@Valid MapBoundSearchForm searchForm) {
		return mapClusterFacadeServiceV2.getClusteredCctvs(searchForm);
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
