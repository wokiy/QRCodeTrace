package com.jackdaw.service;

import java.util.List;
import com.jackdaw.entity.Transport;

/**
 * 业务逻辑层接口。处理和运输相关的业务。
 * @author E-Kunt
 *
 */
public interface TransportService extends ServiceSupport {

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
	 * 查找一个运输信息 立即加载
	 * @param transport
	 * @return
	 * @throws RuntimeException
	 */
	public Transport get(Transport transport) throws RuntimeException;
	
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
	 * 计算运输信息总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;

}
