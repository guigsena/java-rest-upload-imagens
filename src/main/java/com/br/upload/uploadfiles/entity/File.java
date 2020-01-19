package com.br.upload.uploadfiles.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.upload.uploadfiles.enums.StatusFileEnum;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_file")
public class File implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "autoincrement id from file")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ApiModelProperty(value = "Name of file")
	@Column(nullable = false)
    private String name;
	
	@ApiModelProperty(value = "Name of file")
	@Column(nullable = false)
    private String contentType;
	
	@ApiModelProperty(value = "Name of file")
	@Column(nullable = false)
	@Lob
    private String base64;
	
	@ApiModelProperty(value = "User that add file")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
	private User user;
	
	@ApiModelProperty(value = "File status")
	@Column(nullable = false)
	@Enumerated
	private StatusFileEnum status;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StatusFileEnum getStatus() {
		return status;
	}

	public void setStatus(StatusFileEnum status) {
		this.status = status;
	}

	//CONSTRUTORES
	public File() {
		super();
	}

	public File(String name, String contentType, String base64, User user, StatusFileEnum status) {
		this.name = name;
		this.contentType = contentType;
		this.base64 = base64;
		this.user = user;
		this.status = status;
	}

	public File(Long id, String name, String contentType, String base64, User user, StatusFileEnum status) {
		super();
		this.id = id;
		this.name = name;
		this.contentType = contentType;
		this.base64 = base64;
		this.user = user;
		this.status = status;
	}

}
