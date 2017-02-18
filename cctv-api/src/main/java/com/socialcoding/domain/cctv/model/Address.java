package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.AddressEntity;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

	private String address;

	private String regionLocalGovernment; // 광역지방자치단체

	private String basicLocalGovernment; // 기초지방자치단체

	private String nonSelfGovernment; // 비자치구역


	public static Address fromEntity(AddressEntity entity) {
		return new Address(entity.getAddress(), entity.getRegionLocalGovernment(),
			entity.getBasicLocalGovernment(), entity.getNonSelfGovernment());
	}

}
