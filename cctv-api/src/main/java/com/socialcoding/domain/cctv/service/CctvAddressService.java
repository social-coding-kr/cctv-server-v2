package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.entity.AddressEntity;
import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.common.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CctvAddressService {

	private final AddressService addressService;

	@Autowired
	public CctvAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public AddressEntity getAddress(Geolocation geolocation) {
		return null;
	}

}
