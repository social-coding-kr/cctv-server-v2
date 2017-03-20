package com.socialcoding.domain.cctv.service;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.repository.CctvRepository;
import com.socialcoding.domain.map.model.ClusteredCctv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CctvQueryService {

	private final CctvRepository cctvRepository;

	@Autowired
	public CctvQueryService(CctvRepository cctvRepository) {
		this.cctvRepository = cctvRepository;
	}

	public Optional<CctvEntity> findById(Long id) {
		return cctvRepository.findOneById(id);
	}

	public Optional<CctvEntity> findByName(String name) {
		return cctvRepository.findOneByName(name);
	}

	public Collection<CctvEntity> findAll(Predicate predicate) {
		return Lists.newArrayList(cctvRepository.findAll(predicate));
	}

	public long count(Predicate predicate) {
		return cctvRepository.count(predicate);
	}

	public List<ClusteredCctv> groupByClusterId(Predicate predicate) {
		return cctvRepository.groupByClusterId(predicate);
	}
}
