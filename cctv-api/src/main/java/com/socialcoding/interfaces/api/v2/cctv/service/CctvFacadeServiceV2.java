package com.socialcoding.interfaces.api.v2.cctv.service;

import com.socialcoding.domain.cctv.form.UserCctvInsertForm;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.domain.cctv.service.CctvImageService;
import com.socialcoding.interfaces.api.v2.cctv.dto.CctvDto;
import com.socialcoding.interfaces.api.v2.cctv.dto.UserCctvRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

@Service
public class CctvFacadeServiceV2 {

	@Autowired
	private CctvFacadeService cctvFacadeService;

	@Autowired
	private CctvImageService cctvImageService;

	public CctvDto getCctv(String name) {
		return cctvFacadeService.getCctv(name)
			.otherwiseIfEmpty(Mono.error(new IllegalArgumentException("Fail to get cctv: " + name)))
			.doOnError(Exceptions::propagate)
			.map(CctvDto::from)
			.block();
	}

	public void register(UserCctvRegisterForm cctv, MultipartFile cctvImage, MultipartFile noticeImage) {
		String cctvImagePath = cctvImageService.save(cctvImage);
		String noticeImagePath = cctvImageService.save(noticeImage);
		UserCctvInsertForm insertForm = cctv.toInsertForm();
		insertForm.setCctvImagePath(cctvImagePath);
		insertForm.setNoticeImagePath(noticeImagePath);

		cctvFacadeService.insert(insertForm)
			.block();
	}

}
