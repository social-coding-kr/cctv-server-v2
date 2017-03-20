package com.socialcoding.interfaces.api.v1.cctv.dto;

import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Deprecated
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CctvOverviewDto {

	private long cctvId;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String source;

	public static CctvOverviewDto from(Cctv cctv) {
		CctvOverviewDto dto = new CctvOverviewDto();
		dto.setCctvId(cctv.getId());
		dto.setLatitude(cctv.getLocation().getLatitude());
		dto.setLongitude(cctv.getLocation().getLongitude());
		if (CctvType.OFFICIAL == cctv.getType()) {
			dto.setSource(CctvType.Values.LEGACY_OFFICIAL);
		} else if (CctvType.USER == cctv.getType()) {
			dto.setSource(CctvType.Values.LEGACY_USER);
		}
		return dto;
	}

}
