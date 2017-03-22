package com.socialcoding.domain.map.service;

import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.map.entity.MapClusterEntity;
import com.socialcoding.domain.map.repository.MapClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MapClusterQueryService {

	private final MapClusterRepository mapClusterRepository;

	@Autowired
	public MapClusterQueryService(MapClusterRepository mapClusterRepository) {
		this.mapClusterRepository = mapClusterRepository;
	}

	public Flux<MapClusterEntity> findAll() {
		return Flux.defer(() -> Flux.fromIterable(mapClusterRepository.findAll()));
	}

	public Flux<MapClusterEntity> findAll(Predicate predicate) {
		return Flux.defer(() -> Flux.fromIterable(mapClusterRepository.findAll(predicate)));
	}

}
