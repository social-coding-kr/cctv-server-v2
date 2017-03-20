package com.socialcoding.interfaces.api.v1.cctv.dto.response;

import com.socialcoding.interfaces.api.base.ResponseStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Deprecated
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CctvMapCountResponse extends AbstractResponse {

	private long count;

	public static CctvMapCountResponse success(long count) {
		CctvMapCountResponse result = new CctvMapCountResponse();
		result.setStatus(ResponseStatus.SUCCESS);
		result.setCount(count);
		return result;
	}

}
