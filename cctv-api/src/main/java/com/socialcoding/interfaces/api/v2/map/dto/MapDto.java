package com.socialcoding.interfaces.api.v2.map.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MapDto {

	private List<MapCctvDto> cctvs;

	public static MapDto with(List<MapCctvDto> cctvs) {
		return new MapDto(Collections.unmodifiableList(cctvs));
	}

}
