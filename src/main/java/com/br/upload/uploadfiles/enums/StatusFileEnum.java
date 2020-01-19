package com.br.upload.uploadfiles.enums;

public enum StatusFileEnum {
	COMPLETE("COMPLETE"),
	FAIL("FAIL"),
	LOADING("LOADING");
	

	private String status;
	
	StatusFileEnum(String status) {
		this.status = status;
	}
	
	public String status() {
        return status;
    }
	
}
