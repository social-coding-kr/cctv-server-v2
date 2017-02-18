package com.socialcoding.interfaces.api.v2.cctv.dto;

import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvType;
import com.socialcoding.domain.cctv.model.OfficialCctv;
import com.socialcoding.domain.cctv.model.UserCctv;
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
			return OfficialCctvDto.from((OfficialCctv) cctv);
		} else if (CctvType.USER == cctv.getType()) {
			return UserCctvDto.from((UserCctv) cctv);
		} else {
			throw new IllegalArgumentException("Not exist type: " + cctv.getType());
		}
	}

}
