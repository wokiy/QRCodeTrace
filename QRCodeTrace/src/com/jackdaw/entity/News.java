package com.jackdaw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 公司新闻动态
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_news")
public class News implements Serializable {

	private static final long serialVersionUID = 7797145454977267774L;
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 发布日期
	 */
	private Date date;
	
	public News() {

	}
	public News(String title, String content, Date date) {
		this.title = title;
		this.content = content;
		this.date = date;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	
	@Column(columnDefinition="TEXT")
	public String getContent() {
		return content;
	}
	public Date getDate() {
		return date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
