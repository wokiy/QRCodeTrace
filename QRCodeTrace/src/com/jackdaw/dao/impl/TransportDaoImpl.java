package com.jackdaw.dao.impl;

import java.util.List;

import com.jackdaw.dao.TransportDao;
import com.jackdaw.entity.Transport;

/**
 * 运输表数据访问对象
 * @author E-Kunt
 *
 */
public class TransportDaoImpl extends DaoSupportImpl implements TransportDao {

	@Override
	public Transport loadById(int id) throws RuntimeException {
		Transport transport = (Transport) this.getCurrentSession().load(Transport.class, id);
		return transport;
	}

	@Override
	public Transport getById(int id) throws RuntimeException {
		Transport transport = (Transport) this.getCurrentSession().get(Transport.class, id);
		return transport;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transport> findAll() throws RuntimeException {
		String hql = "from Transport";
		List<Transport> transports = this.getCurrentSession().createQuery(hql).list();
		return transports;
	}

	@Override
	public void add(Transport transport) throws RuntimeException {
		this.getCurrentSession().save(transport);
	}

	@Override
	public void update(Transport transport) throws RuntimeException {
		this.getCurrentSession().update(transport);
	}

	@Override
	public void delete(Transport transport) throws RuntimeException {
		this.getCurrentSession().delete(transport);

	}

	@Override
	public long count() throws RuntimeException {
		String hql = "select count(t) from Transport t";
		long count = (long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return count;
	}

}
