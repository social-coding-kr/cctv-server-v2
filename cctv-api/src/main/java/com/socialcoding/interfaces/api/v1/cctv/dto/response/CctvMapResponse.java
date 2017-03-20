package com.socialcoding.interfaces.api.v1.cctv.dto.response;

import com.socialcoding.interfaces.api.base.ResponseStatus;
import com.socialcoding.interfaces.api.v1.cctv.dto.CctvOverviewDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Deprecated
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CctvMapResponse extends AbstractResponse {

	private List<CctvOverviewDto> cctvs;

	public static CctvMapResponse success(List<CctvOverviewDto> cctvs) {
		CctvMapResponse response = new CctvMapResponse();
		response.setCctvs(Collections.unmodifiableList(cctvs));
		response.setStatus(ResponseStatus.SUCCESS);
		return response;
	}

}
