package com.socialcoding.interfaces.api.v1.cctv.dto.response;

import com.socialcoding.interfaces.api.base.ResponseStatus;
import com.socialcoding.interfaces.api.v1.cctv.dto.CctvDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CctvDetailResponse extends AbstractResponse {

	private CctvDto cctv;

	public static CctvDetailResponse success(CctvDto cctv) {
		CctvDetailResponse response = new CctvDetailResponse();
		response.setCctv(cctv);
		response.setStatus(ResponseStatus.SUCCESS);
		return response;
	}

}
