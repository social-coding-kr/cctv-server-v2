package com.socialcoding.domain.cctv.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

	private String address;

	private String regionLocalGovernment; // 광역지방자치단체

	private String basicLocalGovernment; // 기초지방자치단체

	private String nonSelfGovernment; // 비자치구역

}
