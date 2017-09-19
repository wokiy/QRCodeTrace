package com.jackdaw.dao.impl;

import java.util.List;

import com.jackdaw.dao.CompanyDao;
import com.jackdaw.entity.Company;

/**
 * 公司资料表数据访问对象
 * @author E-Kunt
 *
 */
public class CompanyDaoImpl extends DaoSupportImpl implements CompanyDao {

	@Override
	public Company getById(int id) throws RuntimeException {
		Company company = (Company) this.getCurrentSession().get(Company.class, id);
		return company;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAll() throws RuntimeException {
		String hql = "from Company";
		List<Company> company = (List<Company>) this.getCurrentSession().createQuery(hql).list();
		return company;
	}

	@Override
	public void add(Company company) throws RuntimeException {
		this.getCurrentSession().save(company);
	}

	@Override
	public void update(Company company) throws RuntimeException {
		this.getCurrentSession().update(company);
	}

}
