package com.br.upload.uploadfiles.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "autoincrement id from user")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ApiModelProperty(value = "Name of user")
	@Column(nullable = false)
    private String name;

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

	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public User(Long id) {
		this.id = id;
	}
	
	public User() {
		super();
	}
	
	

}
