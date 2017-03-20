package com.socialcoding.interfaces.api.v1.cctv.dto;

import com.socialcoding.domain.cctv.model.OfficialCctv;
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

	public static OfficialCctvDto from(OfficialCctv cctv) {
		OfficialCctvDto dto = new OfficialCctvDto();
		dto.setCctvId(cctv.getId());
		dto.setPurpose(cctv.getExtraProperties().get("purpose"));
		dto.setSource(cctv.getType());
		dto.setAddress(cctv.getAddress().getAddress());
		dto.setBorough(cctv.getAddress().getDistrict());
		dto.setDong(cctv.getExtraProperties().get("range"));
		dto.setDepartment(cctv.getExtraProperties().get("department"));
		dto.setPixel(cctv.getExtraProperties().get("form"));
		dto.setInstalledAt(cctv.getExtraProperties().get("installedAt"));
		return dto;
	}

}
