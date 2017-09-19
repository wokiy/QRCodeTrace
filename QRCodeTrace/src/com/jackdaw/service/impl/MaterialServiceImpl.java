package com.jackdaw.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jackdaw.dao.MaterialDao;
import com.jackdaw.dao.impl.MaterialDaoImpl;
import com.jackdaw.dao.impl.ProductDaoImpl;
import com.jackdaw.entity.Material;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.MaterialService;

/**
 * 业务逻辑层。处理和产品原料相关的业务。
 * @author E-Kunt
 *
 */
public class MaterialServiceImpl extends ServiceSupportImpl implements MaterialService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(MaterialServiceImpl.class);
	/**
	 * 产品原料数据访问对象
	 */
	private MaterialDao materialDao = new MaterialDaoImpl();
	
	
	@Override
	public Material loadById(int id) throws RuntimeException {
		Material material = null;
		LOG.info("尝试根据ID加载一条原料信息。");
		material = materialDao.loadById(id);
		return material;
	}

	@Override
	public Material getById(int id) throws RuntimeException {
		Material material = null;
		LOG.info("尝试根据ID获得一条原料信息。");
		material = materialDao.getById(id);
		return material;
	}
	
	@Override
	public Material get(Material material) throws RuntimeException {
		return getById(material.getId());
	}

	@Override
	public List<Material> findAll() throws RuntimeException {
		List<Material> materials = null;
		LOG.info("尝试获得所有原料信息。");
		materials = materialDao.findAll();
		return materials;
	}

	@Override
	public void add(Material material) throws RuntimeException {
		LOG.info("尝试添加一条原料信息。");
		if (materialDao.getById(material.getId()) != null) {
			LOG.error("添加原料信息失败，该原料信息已存在。");
			throw new ServiceException("添加原料信息失败，该原料信息已存在。");
		}
		if (new ProductDaoImpl().getById(material.getProduct().getId()).getMaterial() != null) {
			LOG.error("添加原料信息失败，该商品已有原料信息");
			throw new ServiceException("添加原料信息失败，该商品已有原料信息");
		}
		materialDao.add(material);

	}

	@Override
	public void update(Material material) throws RuntimeException {
		LOG.info("尝试更新一条原料信息。");
		if (materialDao.getById(material.getId()) == null) {
			LOG.error("更新原料信息失败，该原料信息不存在。");
			throw new ServiceException("更新原料信息失败，该原料信息不存在。");
		}
		materialDao.clearSession();
		materialDao.update(material);

	}

	@Override
	public void delete(Material material) throws RuntimeException {
		LOG.info("尝试删除一条原料信息。");
		materialDao.delete(material);

	}

	@Override
	public long count() throws RuntimeException {
		long count = 0;
		LOG.info("尝试获得所有原料信息的数量。");
		count = materialDao.count();
		return count;
	}

	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, materialDao);
	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, materialDao);
	}

}
