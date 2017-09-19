package com.jackdaw.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 产品原料信息
 * @author E-Kunt
 *
 */
@Entity
@Table(name="t_material")
public class Material implements Serializable  {

	private static final long serialVersionUID = 6490896948324097710L;

	/**
	 * 本表主键ID
	 */
	private int id;
	
	/**
	 * 该信息属于哪个产品
	 */
	private Product product;
	
	/**
	 * 种植企业名称
	 */
	private String companyName;
	/**
	 * 农产品品质
	 * 
	 */
	private String qulity;
	/**
	 * 产地重金属监测结果
	 */
	private String heavyMetal;
	/**
	 * 施肥情况
	 */
	private String fertilization;
	/**
	 * 施药情况
	 */
	private String medicine;
	/**
	 * 农药残留检测结果
	 */
	private String pesticide;
	/**
	 * 亚硝酸盐检测结果
	 */
	private String nitrate;
	/**
	 * 微生物检验结果
	 */
	private String animalcule;
	
	
	public Material() {
		
	}


	public Material(String companyName, String qulity, String heavyMetal, String fertilization, String medicine,
			String pesticide, String nitrate, String animalcule) {
		this.companyName = companyName;
		this.qulity = qulity;
		this.heavyMetal = heavyMetal;
		this.fertilization = fertilization;
		this.medicine = medicine;
		this.pesticide = pesticide;
		this.nitrate = nitrate;
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


	public String getQulity() {
		return qulity;
	}


	public String getHeavyMetal() {
		return heavyMetal;
	}


	public String getFertilization() {
		return fertilization;
	}


	public String getMedicine() {
		return medicine;
	}


	public String getPesticide() {
		return pesticide;
	}


	public String getNitrate() {
		return nitrate;
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


	public void setQulity(String qulity) {
		this.qulity = qulity;
	}


	public void setHeavyMetal(String heavyMetal) {
		this.heavyMetal = heavyMetal;
	}


	public void setFertilization(String fertilization) {
		this.fertilization = fertilization;
	}


	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}


	public void setPesticide(String pesticide) {
		this.pesticide = pesticide;
	}


	public void setNitrate(String nitrate) {
		this.nitrate = nitrate;
	}


	public void setAnimalcule(String animalcule) {
		this.animalcule = animalcule;
	}
	
	
	

}
