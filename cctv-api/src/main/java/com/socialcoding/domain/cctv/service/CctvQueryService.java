package com.socialcoding.domain.cctv.service;

import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.repository.CctvRepository;
import com.socialcoding.domain.map.model.ClusteredCctv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CctvQueryService {

	private final CctvRepository cctvRepository;

	@Autowired
	public CctvQueryService(CctvRepository cctvRepository) {
		this.cctvRepository = cctvRepository;
	}

	public Mono<CctvEntity> findById(Long id) {
		return Mono.fromCallable(() -> cctvRepository.findOne(id));
	}

	public Mono<CctvEntity> findByName(String name) {
		return Mono.fromCallable(() -> cctvRepository.findOneByName(name));
	}

	public Flux<CctvEntity> findAll(Predicate predicate) {
		return Flux.defer(() -> Flux.fromIterable(cctvRepository.findAll(predicate)));
	}

	public Mono<Long> count(Predicate predicate) {
		return Mono.fromCallable(() -> cctvRepository.count(predicate));
	}

	public Flux<ClusteredCctv> groupByClusterId(Predicate predicate) {
		return Flux.defer(() -> Flux.fromIterable(cctvRepository.groupByClusterId(predicate)));
	}

}
