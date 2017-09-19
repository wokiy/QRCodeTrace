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
 * 产品销售信息
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_sell")
public class Sell implements Serializable  {
	private static final long serialVersionUID = -2480183648168846028L;
	/**
	 * 本表主键ID
	 */
	private int id;
	/**
	 * 该信息属于哪个产品
	 */
	private Product product;
	/**
	 * 销售企业名称
	 */
	private String companyName;
	/**
	 * 经营许可证号
	 */
	private String license;
	/**
	 * 法人代表
	 */
	private String logalPerson;
	/**
	 * 直接负责人姓名
	 */
	private String inChargePerson;
	/**
	 * 直接负责人电话
	 */
	private String inChargePhone;
	/**
	 * 进货日期
	 */
	private Date purchaseDate;
	/**
	 * 进货数量
	 */
	private Integer purchaseCount;
	/**
	 * 产品进货后检验情况
	 */
	private String examination;
	/**
	 * 检验人
	 */
	private String examPerson;
	/**
	 * 存货冷库消毒情况
	 */
	private String disinfection;
	/**
	 * 存货冷库温度/℃
	 */
	private Float temperature;
	/**
	 * 存货冷库相对湿度/%
	 */
	private Float humidity;
	/**
	 * 存货负责人
	 */
	private String stockPerson;
	/**
	 * 存货负责人联系电话
	 */
	private String stockPhone;
	/**
	 * 营养标签
	 */
	private String nutrition;
	/**
	 * 过敏提示
	 */
	private String allergy;
	
	public Sell() {
		
	}

	public Sell(String companyName, String license, String logalPerson, String inChargePerson, String inChargePhone,
			Date purchaseDate, Integer purchaseCount, String examination, String examPerson, String disinfection,
			Float temperature, Float humidity, String stockPerson, String stockPhone, String nutrition,
			String allergy) {
		this.companyName = companyName;
		this.license = license;
		this.logalPerson = logalPerson;
		this.inChargePerson = inChargePerson;
		this.inChargePhone = inChargePhone;
		this.purchaseDate = purchaseDate;
		this.purchaseCount = purchaseCount;
		this.examination = examination;
		this.examPerson = examPerson;
		this.disinfection = disinfection;
		this.temperature = temperature;
		this.humidity = humidity;
		this.stockPerson = stockPerson;
		this.stockPhone = stockPhone;
		this.nutrition = nutrition;
		this.allergy = allergy;
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

	public String getLicense() {
		return license;
	}

	public String getLogalPerson() {
		return logalPerson;
	}

	public String getInChargePerson() {
		return inChargePerson;
	}

	public String getInChargePhone() {
		return inChargePhone;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public Integer getPurchaseCount() {
		return purchaseCount;
	}

	public String getExamination() {
		return examination;
	}

	public String getExamPerson() {
		return examPerson;
	}

	public String getDisinfection() {
		return disinfection;
	}

	public Float getTemperature() {
		return temperature;
	}

	public Float getHumidity() {
		return humidity;
	}

	public String getStockPerson() {
		return stockPerson;
	}

	public String getStockPhone() {
		return stockPhone;
	}

	public String getNutrition() {
		return nutrition;
	}

	public String getAllergy() {
		return allergy;
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

	public void setLicense(String license) {
		this.license = license;
	}

	public void setLogalPerson(String logalPerson) {
		this.logalPerson = logalPerson;
	}

	public void setInChargePerson(String inChargePerson) {
		this.inChargePerson = inChargePerson;
	}

	public void setInChargePhone(String inChargePhone) {
		this.inChargePhone = inChargePhone;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setPurchaseCount(Integer purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public void setExamination(String examination) {
		this.examination = examination;
	}

	public void setExamPerson(String examPerson) {
		this.examPerson = examPerson;
	}

	public void setDisinfection(String disinfection) {
		this.disinfection = disinfection;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	public void setStockPerson(String stockPerson) {
		this.stockPerson = stockPerson;
	}

	public void setStockPhone(String stockPhone) {
		this.stockPhone = stockPhone;
	}

	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	
	
	

}
