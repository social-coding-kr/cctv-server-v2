package com.socialcoding.interfaces.api.v2.map.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.socialcoding.domain.map.model.MapBound;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapBoundSearchForm {

	@NotNull
	private BigDecimal south;

	@NotNull
	private BigDecimal west;

	@NotNull
	private BigDecimal north;

	@NotNull
	private BigDecimal east;

	public MapBound toMapBound() {
		return MapBound.of(south, west, north, east);
	}

}
