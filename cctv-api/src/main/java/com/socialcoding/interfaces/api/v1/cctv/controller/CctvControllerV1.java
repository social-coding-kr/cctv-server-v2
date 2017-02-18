package com.socialcoding.interfaces.api.v1.cctv.controller;

import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvDetailResponse;
import com.socialcoding.interfaces.api.v1.cctv.service.CctvFacadeServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Deprecated
public class CctvControllerV1 {

	private final CctvFacadeServiceV1 cctvFacadeServiceV1;

	@Autowired
	public CctvControllerV1(CctvFacadeServiceV1 cctvFacadeServiceV1) {
		this.cctvFacadeServiceV1 = cctvFacadeServiceV1;
	}

	@RequestMapping(value = "/cctv/{id}", method = RequestMethod.GET)
	public CctvDetailResponse get(@PathVariable Long id) {
		return cctvFacadeServiceV1.getDetail(id);
	}

}
