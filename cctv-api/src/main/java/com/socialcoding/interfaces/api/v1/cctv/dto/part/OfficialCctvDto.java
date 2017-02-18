package com.socialcoding.interfaces.api.v1.cctv.dto.part;

import com.socialcoding.domain.cctv.model.Cctv;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfficialCctvDto extends CctvDto {

	private String address;

	private String borough;

	private String dong;

	private String range;

	private String department;

	private String pixel;

	private String form;

	private String installedAt;

	public static OfficialCctvDto from(Cctv cctv) {
		return null;
	}

}
