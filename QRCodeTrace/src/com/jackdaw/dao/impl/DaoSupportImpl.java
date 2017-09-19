package com.jackdaw.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.jackdaw.dao.DaoSupport;
import com.jackdaw.util.HibernateUtil;

/**
 * 基本数据访问对象，提供基本方法的实现
 * @author E-Kunt
 *
 */
public abstract class DaoSupportImpl implements DaoSupport {
	private Session session = null;
	
	@Override
	public Session getCurrentSession() throws RuntimeException {
		if(session != null) {
			return session;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session;
	}
	
	@Override
	public void clearSession() throws RuntimeException {
		getCurrentSession().clear();
	}
	
	@Override
	public void sqlDml(String sql) throws RuntimeException {
		this.getCurrentSession().createSQLQuery(sql).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		List<Object[]> objs = this.getCurrentSession().createSQLQuery(sql).list();
		return objs;
	}

}
