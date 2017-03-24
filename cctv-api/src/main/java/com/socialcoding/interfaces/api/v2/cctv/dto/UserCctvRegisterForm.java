package com.socialcoding.interfaces.api.v2.cctv.dto;

import com.socialcoding.domain.cctv.form.UserCctvInsertForm;
import com.socialcoding.domain.cctv.model.Geolocation;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collections;

@Getter
@Setter
public class UserCctvRegisterForm {

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String purpose;


	public UserCctvInsertForm toInsertForm() {
		UserCctvInsertForm insertForm = new UserCctvInsertForm();
		insertForm.setLocation(Geolocation.of(latitude, longitude));
		insertForm.setExtraProperties(Collections.singletonMap("purpose", purpose));
		return insertForm;
	}

}
