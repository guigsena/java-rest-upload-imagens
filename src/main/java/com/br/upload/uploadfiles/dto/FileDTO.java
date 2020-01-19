package com.br.upload.uploadfiles.dto;

import java.io.Serializable;

public class FileDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String contentType;
	private String base64;
	private Long idUser;
	private String status;
	
	//GETS AND SETS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//CONSTRUTORS
	public FileDTO(Long id, String name, String contentType, String base64, Long idUser, String status) {
		super();
		this.id = id;
		this.name = name;
		this.contentType = contentType;
		this.base64 = base64;
		this.idUser = idUser;
		this.status = status;
	}
	
	public FileDTO() {
		super();
	}
	
}
