package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class OfficialCctv extends Cctv {

	private String dataSource;

	private Map<String, String> extraProperties;

	public static OfficialCctv fromEntity(CctvEntity cctv) {
		return null;
	}

}
