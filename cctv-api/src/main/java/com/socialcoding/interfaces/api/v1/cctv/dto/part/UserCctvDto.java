package com.socialcoding.interfaces.api.v1.cctv.dto.part;

import com.socialcoding.domain.cctv.model.Cctv;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCctvDto extends CctvDto {

	private String cctvImage;

	private String noticeImage;

	public static UserCctvDto from(Cctv cctv) {
		return null;
	}

}
