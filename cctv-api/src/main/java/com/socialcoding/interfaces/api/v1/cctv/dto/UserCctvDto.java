package com.socialcoding.interfaces.api.v1.cctv.dto;

import com.socialcoding.domain.cctv.model.CctvType;
import com.socialcoding.domain.cctv.model.UserCctv;
import lombok.Getter;
import lombok.Setter;

@Deprecated
@Getter
@Setter
public class UserCctvDto extends CctvDto {

	private String cctvImage;

	private String noticeImage;

	public static UserCctvDto from(UserCctv cctv) {
		UserCctvDto dto = new UserCctvDto();
		dto.setCctvId(cctv.getId());
		dto.setPurpose(cctv.getExtraProperties().get("purpose"));
		dto.setSource(CctvType.Values.LEGACY_USER);
		dto.setCctvImage(cctv.getCctvImage());
		dto.setNoticeImage(cctv.getNoticeImage());
		return dto;
	}

}
