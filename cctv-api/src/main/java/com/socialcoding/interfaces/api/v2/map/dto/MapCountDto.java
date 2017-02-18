package com.socialcoding.interfaces.api.v2.map.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MapCountDto {

	private Long count;

	public static MapCountDto with(Long count) {
		return new MapCountDto(count);
	}

}
