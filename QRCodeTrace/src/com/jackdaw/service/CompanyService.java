package com.jackdaw.service;

import com.jackdaw.entity.Company;

/**
 * 业务逻辑层接口。处理和公司相关的业务。
 * @author E-Kunt
 *
 */
public interface CompanyService extends ServiceSupport {

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

}
