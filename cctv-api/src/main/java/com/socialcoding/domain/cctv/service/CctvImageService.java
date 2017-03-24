package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.common.service.FileService;
import com.socialcoding.domain.image.service.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CctvImageService {

	@Autowired
	private FileService fileService;

	@Autowired
	private FlickrService flickrService;


	public String save(MultipartFile file) {
		return null;
	}

}
