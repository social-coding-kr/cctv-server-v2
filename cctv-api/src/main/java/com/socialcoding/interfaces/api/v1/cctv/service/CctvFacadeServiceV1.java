package com.socialcoding.interfaces.api.v1.cctv.service;

import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvSearchConditions;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.interfaces.api.v1.cctv.dto.part.CctvDto;
import com.socialcoding.interfaces.api.v1.cctv.dto.part.CctvOverviewDto;
import com.socialcoding.interfaces.api.v1.cctv.dto.request.CctvMapSearchForm;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvDetailResponse;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvMapCountResponse;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvMapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Deprecated
public class CctvFacadeServiceV1 {

	private final CctvFacadeService cctvFacadeService;

	@Autowired
	public CctvFacadeServiceV1(CctvFacadeService cctvFacadeService) {
		this.cctvFacadeService = cctvFacadeService;
	}

	public CctvDetailResponse getDetail(Long id) {
		return Optional.ofNullable(cctvFacadeService.getCctv(id))
			.map(CctvDto::from)
			.map(CctvDetailResponse::success)
			.orElseThrow(() -> new IllegalArgumentException("Fail to get cctv: " + id));
	}

	public CctvMapResponse listCctvBetween(CctvMapSearchForm searchForm) {
		CctvSearchConditions conditions = new CctvSearchConditions();
		conditions.setMapBound(searchForm.toMapBound());
		List<Cctv> cctvs = cctvFacadeService.listCctvs(conditions);
		return CctvMapResponse.success(cctvs.stream()
			.map(CctvOverviewDto::from)
			.collect(Collectors.toList()));
	}

	public CctvMapCountResponse countCctvBetween(CctvMapSearchForm searchForm) {
		CctvSearchConditions conditions = new CctvSearchConditions();
		conditions.setMapBound(searchForm.toMapBound());
		return Optional.of(cctvFacadeService.countCctvs(conditions))
			.map(CctvMapCountResponse::success)
			.orElseThrow(() -> new IllegalArgumentException("Fail to get cctv: " + searchForm));
	}

}
