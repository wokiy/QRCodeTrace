package com.jackdaw.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 公司信息
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_company")
public class Company implements Serializable  {
	private static final long serialVersionUID = -5992625878485342626L;
	private int id;
	/**
	 * 公司名
	 */
	private String name;
	/**
	 * 公司地址
	 */
	private String address;
	/**
	 * 公司电话
	 */
	private String phone;
	/**
	 * 公司传真
	 */
	private String fax;
	/**
	 * 公司邮箱
	 */
	private String email;
	/**
	 * 公司简介
	 */
	private String introduction;
	
	/**
	 * 公司下面的主图片
	 */
	private String mainPic;
	
	/**
	 * 公司环境 8张小图片
	 */
	private String enviromentPic1;
	private String enviromentPic2;
	private String enviromentPic3;
	private String enviromentPic4;
	private String enviromentPic5;
	private String enviromentPic6;
	private String enviromentPic7;
	private String enviromentPic8;
	
	public Company() {
		
	}
	public Company(String name, String address, String phone, String fax, String email, String introduction) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.introduction = introduction;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getFax() {
		return fax;
	}
	public String getEmail() {
		return email;
	}
	public String getIntroduction() {
		return introduction;
	}
	public String getMainPic() {
		return mainPic;
	}
	public String getEnviromentPic1() {
		return enviromentPic1;
	}
	public String getEnviromentPic2() {
		return enviromentPic2;
	}
	public String getEnviromentPic3() {
		return enviromentPic3;
	}
	public String getEnviromentPic4() {
		return enviromentPic4;
	}
	public String getEnviromentPic5() {
		return enviromentPic5;
	}
	public String getEnviromentPic6() {
		return enviromentPic6;
	}
	public String getEnviromentPic7() {
		return enviromentPic7;
	}
	public String getEnviromentPic8() {
		return enviromentPic8;
	}
	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}
	public void setEnviromentPic1(String enviromentPic1) {
		this.enviromentPic1 = enviromentPic1;
	}
	public void setEnviromentPic2(String enviromentPic2) {
		this.enviromentPic2 = enviromentPic2;
	}
	public void setEnviromentPic3(String enviromentPic3) {
		this.enviromentPic3 = enviromentPic3;
	}
	public void setEnviromentPic4(String enviromentPic4) {
		this.enviromentPic4 = enviromentPic4;
	}
	public void setEnviromentPic5(String enviromentPic5) {
		this.enviromentPic5 = enviromentPic5;
	}
	public void setEnviromentPic6(String enviromentPic6) {
		this.enviromentPic6 = enviromentPic6;
	}
	public void setEnviromentPic7(String enviromentPic7) {
		this.enviromentPic7 = enviromentPic7;
	}
	public void setEnviromentPic8(String enviromentPic8) {
		this.enviromentPic8 = enviromentPic8;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public void setId(int id) {
		this.id = id;
	}
}
