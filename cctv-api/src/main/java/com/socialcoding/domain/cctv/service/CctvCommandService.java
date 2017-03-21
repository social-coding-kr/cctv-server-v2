package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.repository.CctvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CctvCommandService {

	private final CctvRepository cctvRepository;

	@Autowired
	public CctvCommandService(CctvRepository cctvRepository) {
		this.cctvRepository = cctvRepository;
	}

	public Mono<CctvEntity> insert(CctvEntity cctv) {
		return Mono.fromCallable(() -> cctvRepository.save(cctv));
	}

}
