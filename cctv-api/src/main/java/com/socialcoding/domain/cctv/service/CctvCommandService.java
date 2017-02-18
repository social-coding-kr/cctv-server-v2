package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.repository.CctvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CctvCommandService {

	private final CctvRepository cctvRepository;

	@Autowired
	public CctvCommandService(CctvRepository cctvRepository) {
		this.cctvRepository = cctvRepository;
	}

}
