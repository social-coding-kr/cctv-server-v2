package com.socialcoding.interfaces.api.v1.cctv.dto.part;

import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CctvOverviewDto {

	private long cctvId;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private CctvType source;

	public static CctvOverviewDto from(Cctv cctv) {
		return null;
	}

}
