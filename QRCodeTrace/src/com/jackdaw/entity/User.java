package com.jackdaw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户信息
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_user")
public class User implements Serializable  {

	private static final long serialVersionUID = -6336904375670013852L;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 权限
	 * 0:material
	 * 1:process
	 * 2.transport
	 * 3.sell
	 * >4 all
	 */
	private int role;
	
	/**
	 * 法人代表
	 */
	private String realName;
	
	/**
	 * 公司地址
	 */
	private String address;
	
	/**
	 * 管理员联系电话
	 */
	private String phone;
	
	/**
	 * 身份证
	 */
	private String idCard;
	
	/**
	 * 执照码
	 */
	private String licenseNumber;

	/**
	 * 执照照片
	 */
	private String licensePic;
	/**
	 * 电子邮箱
	 */
	private String email;

	public User() {
		
	}

	public User(String userName, String password, int role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public User(String userName, String password, int role, String realName, String address, String phone) {
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.realName = realName;
		this.address = address;
		this.phone = phone;
	}

	@Id
	public String getUserName() {
		return userName;
	}

	@Column(nullable=false)
	public String getPassword() {
		return password;
	}
	
	public String getIdCard() {
		return idCard;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getLicensePic() {
		return licensePic;
	}

	public String getEmail() {
		return email;
	}


	public int getRole() {
		return role;
	}

	public String getRealName() {
		return realName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public void setLicensePic(String licensePic) {
		this.licensePic = licensePic;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
