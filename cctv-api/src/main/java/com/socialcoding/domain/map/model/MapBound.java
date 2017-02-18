package com.socialcoding.domain.map.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor(staticName = "of")
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
