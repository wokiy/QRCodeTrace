package com.jackdaw.service;

import java.util.List;
import com.jackdaw.entity.Sell;

/**
 * 业务逻辑层接口。处理和销售相关的业务。
 * @author E-Kunt
 *
 */
public interface SellService extends ServiceSupport{

	/**
	 * 通过ID查找一个销售信息 延迟加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Sell loadById(int id) throws RuntimeException;

	/**
	 * 通过ID查找一个销售信息 立即加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Sell getById(int id) throws RuntimeException;

	/**
	 * 查找一个销售信息 立即加载
	 * @param sell
	 * @return
	 * @throws RuntimeException
	 */
	public Sell get(Sell sell) throws RuntimeException;

	/**
	 * 查找所有销售信息
	 * @return
	 * @throws RuntimeException
	 */
	public List<Sell> findAll() throws RuntimeException;
	
	/**
	 * 添加销售信息
	 * @param sell
	 * @throws RuntimeException
	 */
	public void add(Sell sell) throws RuntimeException;
	
	/**
	 * 更新销售信息
	 * @param sell
	 * @throws RuntimeException
	 */
	public void update(Sell sell) throws RuntimeException;
	
	/**
	 * 删除某个销售信息
	 * @param sell
	 * @throws RuntimeException
	 */
	public void delete(Sell sell) throws RuntimeException;

	/**
	 * 计算销售信息总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;

}
