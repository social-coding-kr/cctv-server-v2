package com.socialcoding.domain.cctv.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@Embeddable
public class AddressEntity {

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "region_local_government")
	private String regionLocalGovernment; // 광역지방자치단체

	@Column(name = "basic_local_government")
	private String basicLocalGovernment; // 기초지방자치단체

	@Column(name = "non_self_government")
	private String nonSelfGovernment; // 비자치구역

}
