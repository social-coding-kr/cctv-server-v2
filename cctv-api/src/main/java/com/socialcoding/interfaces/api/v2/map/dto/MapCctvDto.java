package com.socialcoding.interfaces.api.v2.map.dto;

import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvType;
import com.socialcoding.domain.cctv.model.Geolocation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapCctvDto {

	private String name;

	private Geolocation location;

	private CctvType type;

	public static MapCctvDto from(Cctv cctv) {
		MapCctvDto dto = new MapCctvDto();
		dto.setName(cctv.getName());
		dto.setLocation(cctv.getLocation());
		dto.setType(cctv.getType());
		return dto;
	}
}
