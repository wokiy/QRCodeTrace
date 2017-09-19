package com.jackdaw.dao.impl;

import java.util.List;

import com.jackdaw.dao.MaterialDao;
import com.jackdaw.entity.Material;

/**
 * 原料表数据访问对象
 * @author E-Kunt
 *
 */
public class MaterialDaoImpl extends DaoSupportImpl implements MaterialDao {

	@Override
	public Material loadById(int id) throws RuntimeException {
		Material material = (Material) this.getCurrentSession().load(Material.class, id);
		return material;
	}

	@Override
	public Material getById(int id) throws RuntimeException {
		Material material = (Material) this.getCurrentSession().get(Material.class, id);
		return material;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> findAll() throws RuntimeException {
		String hql = "from Material";
		List<Material> materials = this.getCurrentSession().createQuery(hql).list();
		return materials;
	}

	@Override
	public void add(Material material) throws RuntimeException {
		this.getCurrentSession().save(material);
	}

	@Override
	public void update(Material material) throws RuntimeException {
		this.getCurrentSession().update(material);
		
	}

	@Override
	public void delete(Material material) throws RuntimeException {
		this.getCurrentSession().delete(material);
	}

	@Override
	public long count() throws RuntimeException {
		String hql = "select count(m) from Material m";
		long count = (long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return count;
	}

}
