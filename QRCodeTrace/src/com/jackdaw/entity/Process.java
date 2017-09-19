package com.jackdaw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 产品加工信息
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_process")
public class Process implements Serializable  {
	
	private static final long serialVersionUID = -3815320980890934687L;
	/**
	 * 本表主键ID
	 */
	private int id;
	/**
	 * 该信息属于哪个产品
	 */
	private Product product;
	/**
	 * 加工企业名称
	 */
	private String companyName;
	/**
	 * 加工方式（净菜或鲜切）
	 */
	private String method;
	/**
	 * 加工车间温度/℃
	 */
	private Float workshopTemperature;
	/**
	 * 包装形式
	 */
	private String packing;
	/**
	 * 入库时间
	 */
	private Date storageTime;
	/**
	 * 冷藏库温度/℃
	 */
	private Float refrigeratorTemperature;

	/**
	 * 出厂前微生物检测结果
	 */
	private String animalcule;

	public Process() {
		
	}

	public Process(String companyName, String method, Float workshopTemperature, String packing,
			Date storageTime, Float refrigeratorTemperature, String animalcule) {
		this.companyName = companyName;
		this.method = method;
		this.workshopTemperature = workshopTemperature;
		this.packing = packing;
		this.storageTime = storageTime;
		this.refrigeratorTemperature = refrigeratorTemperature;
		this.animalcule = animalcule;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	@OneToOne
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return product;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getMethod() {
		return method;
	}

	public Float getWorkshopTemperature() {
		return workshopTemperature;
	}

	public String getPacking() {
		return packing;
	}

	public Date getStorageTime() {
		return storageTime;
	}

	public Float getRefrigeratorTemperature() {
		return refrigeratorTemperature;
	}

	public String getAnimalcule() {
		return animalcule;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setWorkshopTemperature(Float workshopTemperature) {
		this.workshopTemperature = workshopTemperature;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	public void setStorageTime(Date storageTime) {
		this.storageTime = storageTime;
	}

	public void setRefrigeratorTemperature(Float refrigeratorTemperature) {
		this.refrigeratorTemperature = refrigeratorTemperature;
	}

	public void setAnimalcule(String animalcule) {
		this.animalcule = animalcule;
	}
	
	

	
	

}
