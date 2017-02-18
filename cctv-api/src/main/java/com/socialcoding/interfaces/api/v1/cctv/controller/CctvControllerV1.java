package com.socialcoding.interfaces.api.v1.cctv.controller;

import com.socialcoding.interfaces.api.v1.cctv.dto.request.CctvRegistrationForm;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvDetailResponse;
import com.socialcoding.interfaces.api.v1.cctv.dto.response.CctvRegisterResponse;
import com.socialcoding.interfaces.api.v1.cctv.service.CctvFacadeServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@Deprecated
public class CctvControllerV1 {

	private final CctvFacadeServiceV1 cctvFacadeService;

	@Autowired
	public CctvControllerV1(CctvFacadeServiceV1 cctvFacadeServiceV1) {
		this.cctvFacadeService = cctvFacadeServiceV1;
	}

	@RequestMapping(value = "/cctv/{id}", method = RequestMethod.GET)
	public CctvDetailResponse get(@PathVariable Long id) {
		return cctvFacadeService.getDetail(id);
	}

	@RequestMapping(value = "/cctv", method = RequestMethod.POST)
	public CctvRegisterResponse registerPrivateCctv(
		@Valid CctvRegistrationForm cctvRegistrationForm,
		@RequestParam("cctvImage") MultipartFile cctvImage,
		@RequestParam(value = "noticeImage", required = false) MultipartFile noticeImage) {

		validateImage(cctvImage);

		return cctvFacadeService.registerUserCctv(cctvRegistrationForm, cctvImage, noticeImage);

	}

	public static void validateImage(MultipartFile image) {
		if (image == null || StringUtils.isEmpty(image.getOriginalFilename())) {
			throw new IllegalArgumentException("No image file attached");
		}

		if (image.getSize() == 0) {
			throw new IllegalArgumentException("Attached image size is 0");
		}

		if (!image.getContentType().startsWith("image")) {
			throw new IllegalArgumentException("Not image file");
		}
	}

}
