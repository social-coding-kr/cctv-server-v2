package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.common.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CctvImageService {

	private final FileService fileService;

	@Autowired
	public CctvImageService(FileService fileService) {
		this.fileService = fileService;
	}

	public String save(MultipartFile cctvImage) {
		return null;
	}

}
