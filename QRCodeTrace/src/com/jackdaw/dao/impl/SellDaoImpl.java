package com.jackdaw.dao.impl;

import java.util.List;

import com.jackdaw.dao.SellDao;
import com.jackdaw.entity.Sell;

/**
 * 销售表数据访问对象
 * @author E-Kunt
 *
 */
public class SellDaoImpl extends DaoSupportImpl implements SellDao {

	@Override
	public Sell loadById(int id) throws RuntimeException {
		Sell sell = (Sell) this.getCurrentSession().load(Sell.class, id);
		return sell;
	}

	@Override
	public Sell getById(int id) throws RuntimeException {
		Sell sell = (Sell) this.getCurrentSession().get(Sell.class, id);
		return sell;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sell> findAll() throws RuntimeException {
		String hql = "from Sell";
		List<Sell> sells = this.getCurrentSession().createQuery(hql).list();
		return sells;
	}

	@Override
	public void add(Sell sell) throws RuntimeException {
		this.getCurrentSession().save(sell);
	}

	@Override
	public void update(Sell sell) throws RuntimeException {
		this.getCurrentSession().update(sell);

	}

	@Override
	public void delete(Sell sell) throws RuntimeException {
		this.getCurrentSession().delete(sell);
	}

	@Override
	public long count() throws RuntimeException {
		String hql = "select count(s) from Sell s";
		long count = (long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return count;
	}

}
