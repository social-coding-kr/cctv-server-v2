package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.AddressEntity;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
public class Address {

	private String address;

	private String province; // 특별시, 도

	private String district; // 시/군/구

	private String village; // 동


	public static Address fromEntity(AddressEntity entity) {
		return new Address(entity.getAddress(), entity.getProvince(),
			entity.getDistrict(), entity.getVillage());
	}

	public AddressEntity toEntity() {
		AddressEntity entity = new AddressEntity();
		entity.setAddress(this.address);
		entity.setProvince(this.province);
		entity.setDistrict(this.district);
		entity.setVillage(this.village);
		return entity;
	}

}
