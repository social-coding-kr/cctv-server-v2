package com.socialcoding.domain.map.service;

import com.socialcoding.domain.map.entity.MapClusterEntity;
import com.socialcoding.domain.map.form.MapClusterInsertForm;
import com.socialcoding.domain.map.form.MapClusterSearchConditions;
import com.socialcoding.domain.map.model.MapCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MapClusterFacadeService {

	private final MapClusterCommandService mapClusterCommandService;

	private final MapClusterQueryService mapClusterQueryService;

	@Autowired
	public MapClusterFacadeService(MapClusterCommandService mapClusterCommandService, MapClusterQueryService mapClusterQueryService) {
		this.mapClusterCommandService = mapClusterCommandService;
		this.mapClusterQueryService = mapClusterQueryService;
	}

	public Mono<MapCluster> insert(MapClusterInsertForm insertForm) {
		MapClusterEntity entity = insertForm.toEntity();
		return mapClusterCommandService.insert(entity)
			.map(MapCluster::fromEntity);
	}

	public Flux<MapCluster> listMapClusters() {
		return mapClusterQueryService.findAll()
			.map(MapCluster::fromEntity);
	}

	public Flux<MapCluster> listMapClusters(MapClusterSearchConditions conditions) {
		return mapClusterQueryService.findAll(conditions.toPredicate())
			.map(MapCluster::fromEntity);
	}

}
