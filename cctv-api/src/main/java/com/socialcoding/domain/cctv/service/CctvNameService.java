package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.model.Geolocation;
import org.springframework.stereotype.Service;

@Service
public class CctvNameService {

	private static final String SEPARATOR = ".";

	private Integer counter = 0;

	public String generateName(Geolocation geolocation) {
		return new StringBuilder()
			.append(geolocation.getLatitude())
			.append(".")
			.append(geolocation.getLongitude())
			.append(".")
			.append(System.currentTimeMillis())
			.append(SEPARATOR)
			.append(counter++)
			.toString();
	}

}
