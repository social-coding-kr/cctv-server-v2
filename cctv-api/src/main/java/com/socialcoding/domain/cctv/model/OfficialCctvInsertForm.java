package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.OfficialCctvEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfficialCctvInsertForm extends CctvInsertForm {


//	public static OfficialCctvInsertForm formRegisterForm(OfficialCctvRegisterFileForm registerForm) {
//		OfficialCctvInsertForm insertForm = new OfficialCctvInsertForm();
//
//		return insertForm;
//	}

	@Override
	public OfficialCctvEntity toEntity() {
		OfficialCctvEntity entity = new OfficialCctvEntity();
		//FIXME 구현
		return entity;
	}

}
