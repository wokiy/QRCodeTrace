package com.jackdaw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 留言
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = -3634311371190892883L;
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 日期
	 */
	private Date date;
	/**
	 * 对应产品
	 */
	private Product product;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 邮箱
	 */
	private String email;
	
	public Comment() {

	}
	public Comment(String content, Date date) {
		this.content = content;
		this.date = date;
	}
	

	public Comment(String content, Date date, Product product) {
		this.content = content;
		this.date = date;
		this.product = product;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return product;
	}
	public String getContent() {
		return content;
	}
	public Date getDate() {
		return date;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
