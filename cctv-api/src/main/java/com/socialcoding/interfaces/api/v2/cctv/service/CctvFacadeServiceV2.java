package com.socialcoding.interfaces.api.v2.cctv.service;

import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.interfaces.api.v1.cctv.dto.CctvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CctvFacadeServiceV2 {

	private final CctvFacadeService cctvFacadeService;

	@Autowired
	public CctvFacadeServiceV2(CctvFacadeService cctvFacadeService) {
		this.cctvFacadeService = cctvFacadeService;
	}

	public CctvDto getCctv(String name) {
		return Optional.ofNullable(cctvFacadeService.getCctv(name))
			.map(CctvDto::from)
			.orElseThrow(() -> new IllegalArgumentException("Fail to get cctv: " + name));
	}

}
