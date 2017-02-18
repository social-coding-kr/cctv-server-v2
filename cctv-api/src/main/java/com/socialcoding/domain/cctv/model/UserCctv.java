package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class UserCctv extends Cctv {

	private String cctvImage;

	private String noticeImage;

	private Map<String, String> extraProperties;

	public static UserCctv fromEntity(CctvEntity cctv) {
		return null;
	}

}
