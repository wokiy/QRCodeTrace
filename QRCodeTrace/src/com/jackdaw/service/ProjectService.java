package com.jackdaw.service;

import java.util.List;

import com.jackdaw.entity.Project;

/**
 * 业务逻辑层接口。处理和产品项目相关的业务。
 * @author E-Kunt
 *
 */
public interface ProjectService extends ServiceSupport {
	
	/**
	 * 通过产品项目代码取数据
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Project getById(String id) throws RuntimeException;
	
	/**
	 * 取产品项目数据
	 * @param project
	 * @return
	 * @throws RuntimeException
	 */
	public Project get(Project project) throws RuntimeException;
	
	/**
	 * 通过产品项目名称取数据
	 * @param name
	 * @return
	 * @throws RuntimeException
	 */
	public List<Project> getByName(String name) throws RuntimeException;
	
	/**
	 * 获得所有产品项目数据
	 * @return
	 * @throws RuntimeException
	 */
	public List<Project> getAll() throws RuntimeException;
	

	/**
	 * 添加产品项目
	 * @param project
	 * @throws RuntimeException
	 */
	public void add(Project project) throws RuntimeException;
	
	/**
	 * 更新产品项目
	 * @param project
	 * @throws RuntimeException
	 */
	public void update(Project project) throws RuntimeException;
	
	/**
	 * 删除产品项目
	 * @param project
	 * @throws RuntimeException
	 */
	public void delete(Project project) throws RuntimeException;
	
	/**
	 * 查某页的产品项目记录
	 * @param pageNo
	 * @return
	 * @throws RuntimeException
	 */
	public List<Project> findInPage(int pageNo) throws RuntimeException;
	
	/**
	 * 计算产品项目总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;
	
	/**
	 * 获得产品项目总数量
	 * @return
	 * @throws RuntimeException
	 */
	public int getTotalRow() throws RuntimeException;
	
	/**
	 * 获得总页数
	 * @return
	 * @throws RuntimeException
	 */
	public int getTotalPage() throws RuntimeException;
	
	/**
	 * 获得每页显示的产品项目数量
	 * @return
	 * @throws RuntimeException
	 */
	public int getPageRow() throws RuntimeException;

}
