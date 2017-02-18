package com.socialcoding.domain.cctv.model;

public enum CctvType {

    OFFICIAL(Names.OFFICIAL),
    USER(Names.USER);

	private String name;

	CctvType(String name) {
		this.name = name;
	}

	public static class Names {
    	public static final String OFFICIAL = "OFFICIAL";
    	public static final String USER = "USER";
	}

}
