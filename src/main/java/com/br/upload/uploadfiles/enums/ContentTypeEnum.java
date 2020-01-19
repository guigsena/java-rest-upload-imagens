package com.br.upload.uploadfiles.enums;

public enum ContentTypeEnum {
	JPEG("image/jpeg"),
	JFIF("image/jfif"),
	GIF("image/gif"),
	BMP("image/bmp"),
	PNG("image/png");

	private String contentType;
	
	ContentTypeEnum(String contentType) {
		this.contentType = contentType;
	}
	
	public String contentType() {
        return contentType;
    }
	
}
