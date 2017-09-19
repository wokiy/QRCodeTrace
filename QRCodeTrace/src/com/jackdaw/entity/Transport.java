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
 * 运输信息
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_transport")
public class Transport implements Serializable  {

	private static final long serialVersionUID = -2260294148249138216L;
	/**
	 * 本表主键ID
	 */
	private int id;
	/**
	 * 该信息属于哪个产品
	 */
	private Product product;
	/**
	 * 运输公司名称
	 */
	private String companyName;

	/**
	 * 法人代表
	 */
	private String legalPerson;
	/**
	 * 运输车辆类型
	 */
	private String carType;
	/**
	 * 运输车设定温度/℃
	 */
	private Float temperature;
	/**
	 * 运输车相对湿度/%
	 */
	private Float humidity;
	/**
	 * 运输货柜消毒情况
	 */
	private String disinfection;
	/**
	 * 货物种类
	 */
	private String goodsType;
	/**
	 * 货物数量
	 */
	private Integer goodsCount;
	/**
	 * 运输货来源地
	 */
	private String placeFrom;
	/**
	 * 运输货目的地
	 */
	private String placeTo;
	/**
	 * 运输出发时间
	 */
	private Date departureTime;
	/**
	 * 运输到达时间
	 */
	private Date arrivalTime;
	/**
	 * 运输负责人姓名
	 */
	private String personInCharge;
	/**
	 * 运输负责人电话
	 */
	private String phone;
	
	public Transport() {
		
	}
	
	public Transport(String companyName, String legalPerson, String carType, Float temperature, Float humidity,
			String disinfection, String goodsType, Integer goodsCount, String placeFrom, String placeTo, Date departureTime,
			Date arrivalTime, String personInCharge, String phone) {
		this.companyName = companyName;
		this.legalPerson = legalPerson;
		this.carType = carType;
		this.temperature = temperature;
		this.humidity = humidity;
		this.disinfection = disinfection;
		this.goodsType = goodsType;
		this.goodsCount = goodsCount;
		this.placeFrom = placeFrom;
		this.placeTo = placeTo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.personInCharge = personInCharge;
		this.phone = phone;
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

	public String getLegalPerson() {
		return legalPerson;
	}

	public String getCarType() {
		return carType;
	}

	public Float getTemperature() {
		return temperature;
	}

	public Float getHumidity() {
		return humidity;
	}

	public String getDisinfection() {
		return disinfection;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public String getPlaceFrom() {
		return placeFrom;
	}

	public String getPlaceTo() {
		return placeTo;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public String getPhone() {
		return phone;
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

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	public void setDisinfection(String disinfection) {
		this.disinfection = disinfection;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public void setPlaceFrom(String placeFrom) {
		this.placeFrom = placeFrom;
	}

	public void setPlaceTo(String placeTo) {
		this.placeTo = placeTo;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
}
