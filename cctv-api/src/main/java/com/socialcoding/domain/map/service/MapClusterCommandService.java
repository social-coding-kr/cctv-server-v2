package com.socialcoding.domain.map.service;

import com.socialcoding.domain.map.entity.MapClusterEntity;
import com.socialcoding.domain.map.form.MapClusterInsertForm;
import com.socialcoding.domain.map.repository.MapClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class MapClusterCommandService {

	@Autowired
	private MapClusterRepository mapClusterRepository;

	public Mono<MapClusterEntity> insert(MapClusterInsertForm insertForm) {
		return Mono.fromCallable(insertForm::toEntity)
			.map(mapClusterRepository::save);
	}

}
