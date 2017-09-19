package com.jackdaw.service;

import java.util.List;
import com.jackdaw.entity.Material;

/**
 * 业务逻辑层接口。处理和产品原料相关的业务。
 * @author E-Kunt
 *
 */
public interface MaterialService extends ServiceSupport{

	/**
	 * 通过ID查找一个原料信息 延迟加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Material loadById(int id) throws RuntimeException;

	/**
	 * 通过ID查找一个原料信息 立即加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Material getById(int id) throws RuntimeException;
	
	/**
	 * 查找一个原料信息 立即加载
	 * @param material
	 * @return
	 * @throws RuntimeException
	 */
	public Material get(Material material) throws RuntimeException;

	/**
	 * 查找所有原料信息
	 * @return
	 * @throws RuntimeException
	 */
	public List<Material> findAll() throws RuntimeException;
	
	/**
	 * 添加原料信息
	 * @param material
	 * @throws RuntimeException
	 */
	public void add(Material material) throws RuntimeException;

	/**
	 * 更新原料信息
	 * @param material
	 * @throws RuntimeException
	 */
	public void update(Material material) throws RuntimeException;
	
	/**
	 * 删除某个原料信息
	 * @param material
	 * @throws RuntimeException
	 */
	public void delete(Material material) throws RuntimeException;

	/**
	 * 计算原料信息总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;

}
