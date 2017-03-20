package com.socialcoding.domain.cctv.model;

import lombok.Getter;

public enum CctvType {

    OFFICIAL(Values.OFFICIAL),
    USER(Values.USER);

    @Getter
	private String name;

	CctvType(String name) {
		this.name = name;
	}

	public static class Values {
    	public static final String OFFICIAL = "OFFICIAL";
    	public static final String USER = "USER";

    	public static final String LEGACY_OFFICIAL = "PUBLIC";
    	public static final String LEGACY_USER = "PRIVATE";
	}

}
