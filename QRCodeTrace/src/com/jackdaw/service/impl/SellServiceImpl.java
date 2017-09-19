package com.jackdaw.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jackdaw.dao.SellDao;
import com.jackdaw.dao.impl.ProductDaoImpl;
import com.jackdaw.dao.impl.SellDaoImpl;
import com.jackdaw.entity.Sell;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.SellService;

/**
 * 业务逻辑层。处理和产品销售相关的业务。
 * @author E-Kunt
 *
 */
public class SellServiceImpl extends ServiceSupportImpl implements SellService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(SellServiceImpl.class);
	/**
	 * 产品销售数据访问对象
	 */
	private SellDao sellDao = new SellDaoImpl();
	
	@Override
	public Sell loadById(int id) throws RuntimeException {
		Sell sell = null;
		LOG.info("尝试通过ID加载一条销售信息。");
		sell = sellDao.loadById(id);
		return sell;
	}

	@Override
	public Sell getById(int id) throws RuntimeException {
		Sell sell = null;
		LOG.info("尝试通过ID获得一条销售信息。");
		sell = sellDao.getById(id);
		return sell;
	}

	@Override
	public Sell get(Sell sell) throws RuntimeException {
		return getById(sell.getId());
	}

	@Override
	public List<Sell> findAll() throws RuntimeException {
		List<Sell> sells = null;
		LOG.info("尝试获得所有销售信息。");
		sells = sellDao.findAll();
		return sells;
	}

	@Override
	public void add(Sell sell) throws RuntimeException {
		LOG.info("尝试添加一条销售信息。");
		if (sellDao.getById(sell.getId()) != null) {
			LOG.error("添加销售信息失败，该销售信息已存在。");
			throw new ServiceException("添加销售信息失败，该销售信息已存在。");
		}
		if (new ProductDaoImpl().getById(sell.getProduct().getId()).getSell() != null) {
			LOG.error("添加销售信息失败，该商品已有销售信息");
			throw new ServiceException("添加销售信息失败，该商品已有销售信息");
		}
		sellDao.add(sell);

	}

	@Override
	public void update(Sell sell) throws RuntimeException {
		LOG.info("尝试更新一条销售信息。");
		if (sellDao.getById(sell.getId()) == null) {
			LOG.error("更新销售信息失败，该销售信息不存在。");
			throw new ServiceException("更新销售信息失败，该销售信息不存在。");
		}
		sellDao.clearSession();
		sellDao.update(sell);

	}

	@Override
	public void delete(Sell sell) throws RuntimeException {
		LOG.info("尝试删除一条销售信息。");
		sellDao.delete(sell);

	}

	@Override
	public long count() throws RuntimeException {
		long count = 0;
		LOG.info("尝试获得所有销售信息的数量。");
		count = sellDao.count();
		return count;
	}

	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, sellDao);
	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, sellDao);
	}

}
