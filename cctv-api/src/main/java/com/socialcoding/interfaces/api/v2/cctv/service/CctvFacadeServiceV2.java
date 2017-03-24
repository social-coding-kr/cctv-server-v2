package com.socialcoding.interfaces.api.v2.cctv.service;

import com.socialcoding.domain.cctv.form.UserCctvInsertForm;
import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.interfaces.api.v2.cctv.dto.CctvDto;
import com.socialcoding.interfaces.api.v2.cctv.dto.UserCctvRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class CctvFacadeServiceV2 {

	@Autowired
	private CctvFacadeService cctvFacadeService;

	public CctvDto getCctv(String name) {
		return cctvFacadeService.getCctv(name)
			.otherwiseIfEmpty(Mono.error(new IllegalArgumentException("Fail to get cctv: " + name)))
			.doOnError(Exceptions::propagate)
			.map(CctvDto::from)
			.block();
	}

	public void register(UserCctvRegisterForm cctv, MultipartFile cctvImage, MultipartFile noticeImage) {
		Geolocation location = Geolocation.of(cctv.getLatitude(), cctv.getLongitude());
		UserCctvInsertForm insertForm = cctv.toInsertForm();
		insertForm.setCctvImage(cctvImage);
		insertForm.setNoticeImage(noticeImage);
		insertForm.setLocation(location);
		insertForm.setExtraProperties(Collections.singletonMap("purpose", cctv.getPurpose()));

		cctvFacadeService.insert(insertForm)
			.block();
	}

}
