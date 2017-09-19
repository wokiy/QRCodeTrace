package com.jackdaw.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.jackdaw.dao.ProjectDao;
import com.jackdaw.entity.Project;

/**
 * 产品项目表数据访问对象
 * @author E-Kunt
 *
 */
public class ProjectDaoImpl extends DaoSupportImpl implements ProjectDao {

	@Override
	public Project getById(String id) throws RuntimeException {
		Project project = (Project) this.getCurrentSession().get(Project.class, id);
		return project;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getByName(String name) throws RuntimeException {
		String hql = "from Project p where p.name like :name";
		List<Project> projects = this.getCurrentSession().createQuery(hql).setParameter("name", "%" + name + "%")
				.list();
		return projects;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAll() throws RuntimeException {
		String hql = "from Project";
		List<Project> projects = this.getCurrentSession().createQuery(hql)
				.list();
		return projects;
	}

	@Override
	public void add(Project project) throws RuntimeException {
		this.getCurrentSession().save(project);
	}

	@Override
	public void update(Project project) throws RuntimeException {
		this.getCurrentSession().update(project);
	}

	@Override
	public void delete(Project project) throws RuntimeException {
		this.getCurrentSession().delete(project);
	}

	@Override
	public long count() throws RuntimeException {
		String hql = "select count(p) from Project p";
		long count = (long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findLimit(int begin, int end) throws RuntimeException {
		Session session = this.getCurrentSession();
		session.clear();
		String hql = "from Project";
		List<Project> projects = session.createQuery(hql).setFirstResult(begin).setMaxResults(end)
				.list();
		return projects;
	}

}
