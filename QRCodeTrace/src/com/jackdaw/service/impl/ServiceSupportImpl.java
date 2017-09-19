package com.jackdaw.service.impl;

import java.util.List;

import com.jackdaw.dao.DaoSupport;
import com.jackdaw.service.ServiceSupport;

public abstract class ServiceSupportImpl implements ServiceSupport {

	/**
	 * 推荐使用sqlDml(String sql)代替此方法
	 */
	@Override
	public void sqlDml(String sql, DaoSupport dao) throws RuntimeException {
		dao.sqlDml(sql);
	}

	/**
	 * 推荐使用sqlDql(String sql)代替此方法
	 */
	@Override
	public List<Object[]> sqlDql(String sql, DaoSupport dao) throws RuntimeException {
		return dao.sqlDql(sql);
	}

}
