package com.jackdaw.dao.impl;

import java.util.List;

import com.jackdaw.dao.ProcessDao;
import com.jackdaw.entity.Process;

/**
 * 加工表数据访问对象
 * @author E-Kunt
 *
 */
public class ProcessDaoImpl extends DaoSupportImpl implements ProcessDao{

	@Override
	public Process loadById(int id) throws RuntimeException {
		Process process = (Process) this.getCurrentSession().load(Process.class, id);
		return process;
	}

	@Override
	public Process getById(int id) throws RuntimeException {
		Process process = (Process) this.getCurrentSession().get(Process.class, id);
		return process;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Process> findAll() throws RuntimeException {
		String hql = "from Process";
		List<Process> processes = this.getCurrentSession().createQuery(hql).list();
		return processes;
	}

	@Override
	public void add(Process process) throws RuntimeException {
		this.getCurrentSession().save(process);
		
	}

	@Override
	public void update(Process process) throws RuntimeException {
		this.getCurrentSession().update(process);
		
	}

	@Override
	public void delete(Process process) throws RuntimeException {
		this.getCurrentSession().delete(process);
	}

	@Override
	public long count() throws RuntimeException {
		String hql = "select count(p) from Process p";
		long count = (long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return count;
	}

}
