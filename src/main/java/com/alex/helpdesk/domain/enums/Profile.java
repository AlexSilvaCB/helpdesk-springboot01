package com.alex.helpdesk.domain.enums;

public enum Profile {

	ADMIN(1,"ROLE_ADMIN"),
	CLIENT(2,"ROLE_CLIENT"),
	TECHNICAL(3, "ROLE_CLIENT");
	
	private Integer code;
	private String description;
	
	private Profile() {
	}
	
	private Profile(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static Profile toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Profile x: Profile.values()) {
			if(cod.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Profile");
	}
}
