package com.socialcoding.interfaces.api.v1.cctv.dto.part;

import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CctvDto {

	private long cctvId;
	private String purpose;
	private CctvType source; //TODO source -> type

	public static CctvDto from(Cctv cctv) {
		if (CctvType.OFFICIAL == cctv.getType()) {
			return OfficialCctvDto.from(cctv);
		} else if (CctvType.USER == cctv.getType()) {
			return UserCctvDto.from(cctv);
		} else {
			throw new IllegalArgumentException("Not exist type: " + cctv.getType());
		}
	}

}
