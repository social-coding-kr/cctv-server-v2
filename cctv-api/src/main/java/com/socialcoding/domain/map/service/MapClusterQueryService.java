package com.socialcoding.domain.map.service;

import com.socialcoding.domain.map.entity.MapClusterEntity;
import com.socialcoding.domain.map.repository.MapClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapClusterQueryService {

	@Autowired
	private MapClusterRepository mapClusterRepository;

	public List<MapClusterEntity> findAll() {
		return mapClusterRepository.findAll();
	}

}
