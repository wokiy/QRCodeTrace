package com.jackdaw.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jackdaw.dao.ProjectDao;
import com.jackdaw.dao.impl.ProjectDaoImpl;
import com.jackdaw.entity.Project;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.ProjectService;

/**
 * 业务逻辑层。处理和产品项目相关的业务。
 * @author E-Kunt
 *
 */
public class ProjectServiceImpl extends ServiceSupportImpl implements ProjectService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(ProjectServiceImpl.class);
	/**
	 * 产品项目数据访问对象
	 */
	private ProjectDao projectDao = new ProjectDaoImpl();
	
	/**
	 * 分页显示时，每页多少条记录
	 */
	private final int PAGE_ROW = 10;
	
	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, projectDao);

	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, projectDao);
	}

	@Override
	public Project getById(String id) throws RuntimeException {
		Project project = null;
		LOG.info("尝试通过Id获得一条产品项目信息。");
		project = projectDao.getById(id);
		return project;
	}
	
	@Override
	public Project get(Project project) throws RuntimeException {
		return getById(project.getId());
	}

	@Override
	public List<Project> getByName(String name) throws RuntimeException {
		List<Project> projects = null;
		LOG.info("尝试通过名称获得一条产品项目信息。");
		projects = projectDao.getByName(name);
		return projects;
	}

	@Override
	public List<Project> getAll() throws RuntimeException {
		List<Project> projects = null;
		LOG.info("尝试获得所有产品项目信息。");
		projects = projectDao.getAll();
		return projects;
	}

	@Override
	public void add(Project project) throws RuntimeException {
		LOG.info("尝试添加一条产品项目信息。");
		if (projectDao.getById(project.getId()) != null) {
			LOG.error("尝试添加产品项目信息失败，该产品项目已经存在。");
			throw new ServiceException("尝试添加产品项目信息失败，该产品项目已经存在。");
		}
		projectDao.add(project);

	}

	@Override
	public void update(Project project) throws RuntimeException {
		LOG.info("尝试更新一条产品项目信息。");
		if (projectDao.getById(project.getId()) == null) {
			LOG.error("更新产品项目失败，该产品项目不存在。");
			throw new ServiceException("更新产品项目失败，该产品项目不存在。");
		}
		projectDao.clearSession();
		projectDao.update(project);

	}

	@Override
	public void delete(Project project) throws RuntimeException {
		LOG.info("尝试删除一条产品项目信息。");
		projectDao.delete(project);
	}

	@Override
	public List<Project> findInPage(int pageNo) throws RuntimeException {
		List<Project> projects = null;
		LOG.info("尝试获得第"+ pageNo +"页所有的产品信息。");
		// 产品表记录的总数量
		int totalRows = (int) projectDao.count();
		// 显示所有产品一共需要多少页
		int totalPages = (totalRows + PAGE_ROW - 1) / PAGE_ROW;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > totalPages) {
			pageNo = totalPages;
		}
		projects = projectDao.findLimit((pageNo - 1) * PAGE_ROW, PAGE_ROW);
		return projects;
	}

	@Override
	public long count() throws RuntimeException {
		long count = 0;
		LOG.info("尝试获得所有产品项目的数量。");
		count = projectDao.count();
		return count;
	}

	@Override
	public int getTotalRow() throws RuntimeException {
		return (int) projectDao.count();
	}

	@Override
	public int getTotalPage() throws RuntimeException {
		return (getTotalRow() + getPageRow() - 1) / getPageRow();
	}

	@Override
	public int getPageRow() throws RuntimeException {
		return PAGE_ROW;
	}
}
