package com.jackdaw.dao;

import java.util.List;
import com.jackdaw.entity.Transport;

/**
 * 运输信息表数据访问对象接口
 * @author E-Kunt
 *
 */
public interface TransportDao extends DaoSupport{

	/**
	 * 通过ID查找一个运输信息 延迟加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Transport loadById(int id) throws RuntimeException;

	/**
	 * 通过ID查找一个运输信息 立即加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Transport getById(int id) throws RuntimeException;

	/**
	 * 查找所有运输信息
	 * @return
	 * @throws RuntimeException
	 */
	public List<Transport> findAll() throws RuntimeException;
	
	/**
	 * 添加运输信息
	 * @param transport
	 * @throws RuntimeException
	 */
	public void add(Transport transport) throws RuntimeException;
	
	/**
	 * 更新运输信息
	 * @param transport
	 * @throws RuntimeException
	 */
	public void update(Transport transport) throws RuntimeException;

	/**
	 * 删除某个运输信息
	 * @param transport
	 * @throws RuntimeException
	 */
	public void delete(Transport transport) throws RuntimeException;

	/**
	 * 计算运输信息表数据总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;

}
