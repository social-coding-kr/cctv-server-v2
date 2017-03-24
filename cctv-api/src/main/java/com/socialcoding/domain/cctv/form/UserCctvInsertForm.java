package com.socialcoding.domain.cctv.form;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCctvInsertForm extends CctvInsertForm {

	private String cctvImagePath;

	private String noticeImagePath;

	@Override
	public CctvEntity toEntity() {
		return null;
	}

}
