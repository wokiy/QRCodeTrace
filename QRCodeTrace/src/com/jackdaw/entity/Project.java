package com.jackdaw.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 公司启动的商品项目
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1021798095798839038L;
	/**
	 * 商品项目代码（规定5位）
	 */
	private String id;
	/**
	 * 商品项目名称
	 */
	private String name;
	
	public Project() {
		
	}

	public Project(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
