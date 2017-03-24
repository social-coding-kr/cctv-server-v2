package com.socialcoding.interfaces.api.v2.cctv.dto;

import com.socialcoding.domain.cctv.form.UserCctvInsertForm;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserCctvRegisterForm {

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String purpose;


	public UserCctvInsertForm toInsertForm() {
		return null;
	}

}
