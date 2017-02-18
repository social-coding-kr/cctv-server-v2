package com.socialcoding.interfaces.api.v1.cctv.controller;

import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvMapCountResponse;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvMapResponse;
import com.socialcoding.interfaces.api.v1.cctv.dto.request.CctvMapSearchForm;
import com.socialcoding.interfaces.api.v1.cctv.service.CctvFacadeServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Deprecated
public class CctvMapControllerV1 {

	private final CctvFacadeServiceV1 cctvFacadeServiceV1;

	@Autowired
	public CctvMapControllerV1(CctvFacadeServiceV1 cctvFacadeServiceV1) {
		this.cctvFacadeServiceV1 = cctvFacadeServiceV1;
	}

	@RequestMapping(value = "/map/cctvs", method = RequestMethod.GET)
	public CctvMapResponse getCctvs(@Valid CctvMapSearchForm searchForm) {
		return cctvFacadeServiceV1.listCctvBetween(searchForm);
	}

	@RequestMapping(value = "/map/cctvs/counts", method = RequestMethod.GET)
	public CctvMapCountResponse getCctvCounts(@Valid CctvMapSearchForm searchForm) {
		return cctvFacadeServiceV1.countCctvBetween(searchForm);
	}

}
