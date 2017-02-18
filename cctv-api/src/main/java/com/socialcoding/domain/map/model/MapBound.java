package com.socialcoding.domain.map.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class MapBound {

	@NotNull
	private BigDecimal south;

	@NotNull
	private BigDecimal west;

	@NotNull
	private BigDecimal north;

	@NotNull
	private BigDecimal east;

}
