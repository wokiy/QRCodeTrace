package com.jackdaw.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jackdaw.dao.TransportDao;
import com.jackdaw.dao.impl.ProductDaoImpl;
import com.jackdaw.dao.impl.TransportDaoImpl;
import com.jackdaw.entity.Transport;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.TransportService;

public class TransportServiceImpl extends ServiceSupportImpl implements TransportService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(TransportServiceImpl.class);
	/**
	 * 产品运输数据访问对象
	 */
	private TransportDao transportDao = new TransportDaoImpl();
	
	@Override
	public Transport loadById(int id) throws RuntimeException {
		Transport transport = null;
		LOG.info("尝试通过ID加载一条运输信息。");
		transport = transportDao.loadById(id);
		return transport;
	}

	@Override
	public Transport getById(int id) throws RuntimeException {
		Transport transport = null;
		LOG.info("尝试通过ID获得一条运输信息。");
		transport = transportDao.getById(id);
		return transport;
	}

	@Override
	public Transport get(Transport transport) throws RuntimeException {
		return getById(transport.getId());
	}

	@Override
	public List<Transport> findAll() throws RuntimeException {
		List<Transport> transport = null;
		LOG.info("尝试获得所有运输信息。");
		transport = transportDao.findAll();
		return transport;
	}

	@Override
	public void add(Transport transport) throws RuntimeException {
		LOG.info("尝试添加一条运输信息。");
		if (transportDao.getById(transport.getId()) != null) {
			LOG.error("添加运输信息失败，该运输信息已存在。");
			throw new ServiceException("添加运输信息失败，该运输信息已存在。");
		}
		if (new ProductDaoImpl().getById(transport.getProduct().getId()).getTransport() != null) {
			LOG.error("添加运输信息失败，该商品已有运输信息");
			throw new ServiceException("添加运输信息失败，该商品已有运输信息");
		}
		transportDao.add(transport);
	}

	@Override
	public void update(Transport transport) throws RuntimeException {
		LOG.info("尝试更新一条运输信息。");
		if (transportDao.getById(transport.getId()) == null) {
			LOG.error("更新运输信息失败，该运输信息不存在。");
			throw new ServiceException("更新运输信息失败，该运输信息不存在。");
		}
		transportDao.clearSession();
		transportDao.update(transport);

	}

	@Override
	public void delete(Transport transport) throws RuntimeException {
		LOG.info("尝试删除一条运输信息。");
		transportDao.delete(transport);

	}

	@Override
	public long count() throws RuntimeException {
		long count = 0;
		LOG.info("尝试获得所有运输信息的数量。");
		count = transportDao.count();
		return count;
	}

	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, transportDao);
	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, transportDao);
	}

}
