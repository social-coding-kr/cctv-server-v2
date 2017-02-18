package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.model.Geolocation;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CctvNameService {

	public String generateName(Geolocation geolocation) {
		return new StringBuilder()
			.append(geolocation.getLatitude())
			.append("_")
			.append(geolocation.getLongitude())
			.append("_")
			.append(UUID.randomUUID())
			.toString();
	}

}
