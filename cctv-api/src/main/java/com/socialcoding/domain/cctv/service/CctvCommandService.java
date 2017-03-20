package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.entity.OfficialCctvEntity;
import com.socialcoding.domain.cctv.repository.CctvRepository;
import com.socialcoding.domain.cctv.repository.OfficialCctvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CctvCommandService {

	private final CctvRepository cctvRepository;

	@Autowired
	private OfficialCctvRepository officialCctvRepository;

	@Autowired
	public CctvCommandService(CctvRepository cctvRepository) {
		this.cctvRepository = cctvRepository;
	}

	public CctvEntity insert(CctvEntity cctv) {
		return cctvRepository.save(cctv);
	}

	public OfficialCctvEntity insert(OfficialCctvEntity entity) {
		return officialCctvRepository.save(entity);
	}

}
