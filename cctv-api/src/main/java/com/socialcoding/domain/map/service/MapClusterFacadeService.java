package com.socialcoding.domain.map.service;

import com.socialcoding.domain.map.model.MapClusterInsertForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapClusterFacadeService {

	@Autowired
	private MapClusterCommandService mapClusterCommandService;

	public void insert(MapClusterInsertForm insertForm) {
		mapClusterCommandService.insert(insertForm);
	}

}
