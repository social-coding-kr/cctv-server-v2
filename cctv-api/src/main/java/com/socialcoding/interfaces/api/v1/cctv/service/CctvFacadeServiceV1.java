package com.socialcoding.interfaces.api.v1.cctv.service;

import com.socialcoding.domain.cctv.form.CctvSearchConditions;
import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.interfaces.api.v1.cctv.dto.CctvDto;
import com.socialcoding.interfaces.api.v1.cctv.dto.CctvOverviewDto;
import com.socialcoding.interfaces.api.v1.cctv.dto.request.CctvMapSearchForm;
import com.socialcoding.interfaces.api.v1.cctv.dto.request.CctvRegistrationForm;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvDetailResponse;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvMapCountResponse;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvMapResponse;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

@Service
@Deprecated
public class CctvFacadeServiceV1 {

	private final CctvFacadeService cctvFacadeService;

	@Autowired
	public CctvFacadeServiceV1(CctvFacadeService cctvFacadeService) {
		this.cctvFacadeService = cctvFacadeService;
	}

	public CctvDetailResponse getDetail(Long id) {
		return cctvFacadeService.getCctv(id)
			.otherwiseIfEmpty(Mono.error(new IllegalArgumentException("Fail to get cctv: " + id)))
			.doOnError(Exceptions::propagate)
			.map(CctvDto::from)
			.map(CctvDetailResponse::success)
			.block();
	}

	public CctvMapResponse listCctvBetween(CctvMapSearchForm searchForm) {
		CctvSearchConditions condition = new CctvSearchConditions();
		condition.setMapBound(searchForm.toMapBound());

		return cctvFacadeService.listCctv(condition)
			.map(CctvOverviewDto::from)
			.collectList()
			.map(CctvMapResponse::success)
			.block();
	}

	public CctvMapCountResponse countCctvBetween(CctvMapSearchForm searchForm) {
		CctvSearchConditions condition = new CctvSearchConditions();
		condition.setMapBound(searchForm.toMapBound());

		return cctvFacadeService.countCctvs(condition)
			.otherwiseIfEmpty(Mono.error(new IllegalArgumentException("Fail to get cctv: " + searchForm)))
			.doOnError(Exceptions::propagate)
			.map(CctvMapCountResponse::success)
			.block();
	}

	public CctvRegisterResponse registerUserCctv(CctvRegistrationForm form, MultipartFile cctvImage, MultipartFile noticeImage) {
		Cctv cctv = cctvFacadeService.registerUserCctv(form, cctvImage, noticeImage);
		return CctvRegisterResponse.success(cctv.getId());
	}

}
