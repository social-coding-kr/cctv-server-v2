package com.socialcoding.domain.cctv.form;

import com.socialcoding.domain.cctv.entity.UserCctvEntity;
import com.socialcoding.domain.cctv.model.Geolocation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UserCctvInsertForm extends CctvInsertForm {

	private MultipartFile cctvImage;

	private MultipartFile noticeImage;

	private Geolocation location;

	private Map<String, String> extraProperties = new HashMap<>();


	public UserCctvEntity toEntity() {
		return null;
	}

}
