package com.socialcoding.interfaces.api.v2.map.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MapCctvCountDto {

	private Long count;

	public static MapCctvCountDto with(Long count) {
		return new MapCctvCountDto(count);
	}

}
