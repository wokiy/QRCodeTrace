package com.jackdaw.dao;

import java.util.List;
import com.jackdaw.entity.Process;

/**
 * 加工表数据访问对象接口
 * @author E-Kunt
 *
 */
public interface ProcessDao extends DaoSupport{

	/**
	 * 通过ID查找一个加工信息 延迟加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Process loadById(int id) throws RuntimeException;
	
	/**
	 * 通过ID查找一个加工信息 立即加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Process getById(int id) throws RuntimeException;

	/**
	 * 查找所有加工信息
	 * @return
	 * @throws RuntimeException
	 */
	public List<Process> findAll() throws RuntimeException;
	
	/**
	 * 添加加工信息
	 * @param process
	 * @throws RuntimeException
	 */
	public void add(Process process) throws RuntimeException;

	/**
	 * 更新加工信息
	 * @param process
	 * @throws RuntimeException
	 */
	public void update(Process process) throws RuntimeException;

	/**
	 * 删除某个加工信息
	 * @param process
	 * @throws RuntimeException
	 */
	public void delete(Process process) throws RuntimeException;

	/**
	 * 计算加工表信息总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;
}
