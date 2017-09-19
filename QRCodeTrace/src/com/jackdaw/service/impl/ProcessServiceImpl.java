package com.jackdaw.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jackdaw.dao.ProcessDao;
import com.jackdaw.dao.impl.ProcessDaoImpl;
import com.jackdaw.dao.impl.ProductDaoImpl;
import com.jackdaw.entity.Process;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.ProcessService;
/**
 * 业务逻辑层。处理和产品加工相关的业务。
 * @author E-Kunt
 *
 */
public class ProcessServiceImpl extends ServiceSupportImpl implements ProcessService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(ProcessServiceImpl.class);
	/**
	 * 产品加工数据访问对象
	 */
	private ProcessDao processDao = new ProcessDaoImpl();
	
	@Override
	public Process loadById(int id) throws RuntimeException {
		Process process = null;
		LOG.info("尝试通过ID加载一条加工信息。");
		process = processDao.loadById(id);
		return process;
	}

	@Override
	public Process getById(int id) throws RuntimeException {
		Process process = null;
		LOG.info("尝试通过ID获得一条加工信息。");
		process = processDao.getById(id);
		return process;
	}
	
	@Override
	public Process get(Process process) throws RuntimeException {
		return getById(process.getId());
	}

	@Override
	public List<Process> findAll() throws RuntimeException {
		List<Process> processes = null;
		LOG.info("尝试获得所有加工信息。");
		processes = processDao.findAll();
		return processes;
	}

	@Override
	public void add(Process process) throws RuntimeException {
		LOG.info("尝试添加一条加工信息。");
		if (processDao.getById(process.getId()) != null) {
			LOG.error("添加加工信息失败，该加工信息已存在。");
			throw new ServiceException("添加加工信息失败，该加工信息已存在。");
		}
		if (new ProductDaoImpl().getById(process.getProduct().getId()).getProcess() != null) {
			LOG.error("添加加工信息失败，该商品已有加工信息。");
			throw new ServiceException("添加加工信息失败，该商品已有加工信息。");
		}
		processDao.add(process);
	}

	@Override
	public void update(Process process) throws RuntimeException {
		LOG.info("尝试更新一条加工信息。");
		if (processDao.getById(process.getId()) == null) {
			LOG.error("更新加工信息失败，该加工信息不存在。");
			throw new ServiceException("更新加工信息失败，该加工信息不存在。");
		}
		processDao.clearSession();
		processDao.update(process);
	}

	@Override
	public void delete(Process process) throws RuntimeException {
		LOG.info("尝试删除一条加工信息。");
		processDao.delete(process);

	}

	@Override
	public long count() throws RuntimeException {
		long count = 0;
		LOG.info("尝试获得所有加工信息的数量。");
		count = processDao.count();
		return count;
	}

	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, processDao);
		
	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, processDao);
	}

}
