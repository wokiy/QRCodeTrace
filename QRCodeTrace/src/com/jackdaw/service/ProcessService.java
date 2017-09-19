package com.jackdaw.service;

import java.util.List;
import com.jackdaw.entity.Process;

/**
 * 业务逻辑层接口。处理和加工相关的业务。
 * @author E-Kunt
 *
 */
public interface ProcessService extends ServiceSupport{

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
	 * 查找一个加工信息 立即加载
	 * @param process
	 * @return
	 * @throws RuntimeException
	 */
	public Process get(Process process) throws RuntimeException;
	
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
	 * 计算加工信息总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;
}
