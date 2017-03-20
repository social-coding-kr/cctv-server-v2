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

	private String province; // 특별시, 도

	private String district; // 시/군/구

	private String village; // 동

}
