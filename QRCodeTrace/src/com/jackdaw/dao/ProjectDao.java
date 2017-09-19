package com.jackdaw.dao;

import java.util.List;

import com.jackdaw.entity.Project;

/**
 * 产品项目表数据访问对象接口
 * @author E-Kunt
 *
 */
public interface ProjectDao extends DaoSupport {

	/**
	 * 通过产品项目代码取数据
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Project getById(String id) throws RuntimeException;
	
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
	 * 计算产品项目总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;
	
	/**
	 * 查行区间内的产品记录
	 * @param begin
	 * @param end
	 * @return
	 * @throws RuntimeException
	 */
	public List<Project> findLimit(int begin, int end) throws RuntimeException;

}
