package com.jackdaw.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 产品信息
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_product")
public class Product implements Serializable  {

	private static final long serialVersionUID = -2546932611708481908L;
	/**
	 * 产品追溯码
	 */
	private String id;
	/**
	 * 产品名称
	 */
	private String name;
	/**
	 * 产品图片（地址）
	 */
	private String pic;
	
	/**
	 * 原料信息
	 */
	private Material material;
	/**
	 * 加工信息
	 */
	private Process process;
	/**
	 * 销售信息
	 */
	private Sell sell;
	/**
	 * 运输信息
	 */
	private Transport transport;
	
	/**
	 * 留言信息
	 */
	private Set<Comment> comments = new HashSet<Comment>();
	


	public Product() {
		
	}

	public Product(String id, String name) {
		this.id = id;
		this.name = name;
	}
	

	public Product(String id, String name, String pic) {
		this.id = id;
		this.name = name;
		this.pic = pic;
	}

	@Id
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getPic() {
		return pic;
	}
	
	@OneToOne(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Material getMaterial() {
		return material;
	}

	@OneToOne(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Process getProcess() {
		return process;
	}

	@OneToOne(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Sell getSell() {
		return sell;
	}

	@OneToOne(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Transport getTransport() {
		return transport;
	}
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
}
