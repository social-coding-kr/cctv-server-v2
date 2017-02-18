package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Cctv {

    private Long id;

	private String name;

	private Geolocation location;

	private Address address;

    private CctvType type;

	public static Cctv fromEntity(CctvEntity cctv) {
		if (CctvType.OFFICIAL == cctv.getType()) {
			return OfficialCctv.fromEntity(cctv);
		} else if (CctvType.USER == cctv.getType()) {
			return UserCctv.fromEntity(cctv);
		} else {
			throw new IllegalArgumentException("Not existing type: " + cctv.getType());
		}
	}

}
