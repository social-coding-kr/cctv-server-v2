package com.socialcoding.interfaces.api.base.error;

import com.socialcoding.interfaces.api.base.ResponseStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestError {

	private ResponseStatus status;
	private int errorCode;
	private String errorMessage;

	public static RestError of(int errorCode, Throwable throwable) {
		return new RestError(ResponseStatus.FAILURE, errorCode, throwable.getMessage());
	}

}
