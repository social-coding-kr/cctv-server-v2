package com.socialcoding.domain.base.entity;

import org.springframework.data.domain.AuditorAware;

public class AuditorInjector implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return "self|admin";
	}

}
