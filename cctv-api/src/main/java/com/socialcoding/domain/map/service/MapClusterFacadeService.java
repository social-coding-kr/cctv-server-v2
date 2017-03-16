package com.socialcoding.domain.map.service;

import com.socialcoding.domain.map.model.MapCluster;
import com.socialcoding.domain.map.model.MapClusterInsertForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapClusterFacadeService {

	@Autowired
	private MapClusterCommandService mapClusterCommandService;

	@Autowired
	private MapClusterQueryService mapClusterQueryService;

	public void insert(MapClusterInsertForm insertForm) {
		mapClusterCommandService.insert(insertForm);
	}

	public List<MapCluster> listMapClusters() {
		return mapClusterQueryService.findAll().stream()
			.map(MapCluster::fromEntity)
			.collect(Collectors.toList());
	}

}
