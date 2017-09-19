package com.jackdaw.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jackdaw.dao.CompanyDao;
import com.jackdaw.dao.impl.CompanyDaoImpl;
import com.jackdaw.entity.Company;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.CompanyService;

/**
 * 业务逻辑层。处理和公司相关的业务。
 * @author E-Kunt
 *
 */
public class CompanyServiceImpl extends ServiceSupportImpl implements CompanyService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(CompanyServiceImpl.class);
	/**
	 * 产品原料数据访问对象
	 */
	private CompanyDao companyDao = new CompanyDaoImpl();
	
	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, companyDao);

	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, companyDao);
	}

	@Override
	public Company getById(int id) throws RuntimeException {
		Company company = null;
		LOG.info("尝试通过ID加载一条公司信息。");
		company = companyDao.getById(id);
		return company;
	}

	@Override
	public void add(Company company) throws RuntimeException {
		LOG.info("尝试添加一条公司信息。");
		if (!companyDao.findAll().isEmpty()) {
			LOG.error("添加公司信息失败，该记录已存在。");
			throw new ServiceException("添加公司信息失败，该记录已存在。");
		}
		companyDao.add(company);

	}

	@Override
	public void update(Company company) throws RuntimeException {
		LOG.info("尝试更新一条公司信息");
		if (companyDao.findAll().isEmpty()) {
			LOG.error("更新公司信息失败，该记录不存在。");
			throw new ServiceException("更新公司信息失败，该记录不存在。");
		}
		companyDao.clearSession();
		companyDao.update(company);

	}

}
