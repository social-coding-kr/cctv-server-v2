package com.socialcoding.domain.cctv.form;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.model.Address;
import com.socialcoding.domain.cctv.model.Geolocation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CctvInsertForm {

	private String name;

	private String clusterId;

	private Geolocation location;

	private Address address;


	public abstract CctvEntity toEntity();

}
