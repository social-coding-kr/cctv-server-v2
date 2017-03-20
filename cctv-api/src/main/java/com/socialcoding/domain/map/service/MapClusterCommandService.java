package com.socialcoding.domain.map.service;

import com.socialcoding.domain.map.entity.MapClusterEntity;
import com.socialcoding.domain.map.form.MapClusterInsertForm;
import com.socialcoding.domain.map.repository.MapClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MapClusterCommandService {

	@Autowired
	private MapClusterRepository mapClusterRepository;

	public void insert(MapClusterInsertForm insertForm) {
		MapClusterEntity entity = insertForm.toEntity();
		mapClusterRepository.save(entity);
	}

}
