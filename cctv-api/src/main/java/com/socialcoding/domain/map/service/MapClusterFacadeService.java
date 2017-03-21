package com.socialcoding.domain.map.service;

import com.socialcoding.domain.map.form.MapClusterInsertForm;
import com.socialcoding.domain.map.model.MapCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MapClusterFacadeService {

	@Autowired
	private MapClusterCommandService mapClusterCommandService;

	@Autowired
	private MapClusterQueryService mapClusterQueryService;

	public Mono<MapCluster> insert(MapClusterInsertForm insertForm) {
		return mapClusterCommandService.insert(insertForm)
			.map(MapCluster::fromEntity);
	}

	public Flux<MapCluster> listMapClusters() {
		return mapClusterQueryService.findAll()
			.map(MapCluster::fromEntity);
	}

}
