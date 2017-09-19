package com.jackdaw.dao;

import java.util.List;

import com.jackdaw.entity.Company;

/**
 * 公司资料表数据访问对象接口
 * @author E-Kunt
 *
 */
public interface CompanyDao extends DaoSupport {
	/**
	 * 通过id取数据
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Company getById(int id) throws RuntimeException;
	

	/**
	 * 添加公司资料
	 * @param company
	 * @throws RuntimeException
	 */
	public void add(Company company) throws RuntimeException;
	
	/**
	 * 更新公司资料
	 * @param company
	 * @throws RuntimeException
	 */
	public void update(Company company) throws RuntimeException;


	/**
	 * 获取公司资料
	 * @return
	 * @throws RuntimeException
	 */
	public List<Company> findAll() throws RuntimeException;

}
