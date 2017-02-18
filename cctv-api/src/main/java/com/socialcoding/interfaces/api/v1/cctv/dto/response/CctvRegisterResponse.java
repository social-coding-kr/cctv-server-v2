package com.socialcoding.interfaces.api.v1.cctv.dto.response;

import com.socialcoding.interfaces.api.base.ResponseStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CctvRegisterResponse extends AbstractResponse {

	private Long cctvId;

	public static CctvRegisterResponse success(long cctvId) {
		CctvRegisterResponse response = new CctvRegisterResponse();
		response.setCctvId(cctvId);
		response.setStatus(ResponseStatus.SUCCESS);
		return response;
	}

}
