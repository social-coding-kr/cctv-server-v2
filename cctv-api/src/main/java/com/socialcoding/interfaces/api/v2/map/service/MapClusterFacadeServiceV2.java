package com.socialcoding.interfaces.api.v2.map.service;

import com.socialcoding.domain.map.model.MapClusterInsertForm;
import com.socialcoding.domain.map.service.MapClusterFacadeService;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusterRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapClusterFacadeServiceV2 {

	private final MapClusterFacadeService mapClusterFacadeService;

	@Autowired
	public MapClusterFacadeServiceV2(MapClusterFacadeService mapClusterFacadeService) {
		this.mapClusterFacadeService = mapClusterFacadeService;
	}

	public void register(MapClusterRegisterForm registerForm) {
		mapClusterFacadeService.insert(MapClusterInsertForm.fromRegisterForm(registerForm));
	}

}
