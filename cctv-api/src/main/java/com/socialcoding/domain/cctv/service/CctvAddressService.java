package com.socialcoding.domain.cctv.service;

import com.socialcoding.domain.cctv.model.Address;
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

	public Address getAddress(Geolocation geolocation) {
		return null;
	}

}
