package com.jackdaw.dao;

import java.util.List;
import com.jackdaw.entity.Product;

/**
 * 产品表数据访问对象接口
 * @author E-Kunt
 *
 */
public interface ProductDao extends DaoSupport{

	/**
	 * 通过ID获得一个产品 延迟加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Product loadById(String id) throws RuntimeException;

	/**
	 * 通过ID获得一个产品 立即加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Product getById(String id) throws RuntimeException;

	/**
	 * 通过名字查找产品
	 * @param name
	 * @return
	 * @throws RuntimeException
	 */
	public List<Product> getByName(String name) throws RuntimeException;

	/**
	 * 查找所有产品
	 * @return
	 * @throws RuntimeException
	 */
	public List<Product> findAll() throws RuntimeException;

	/**
	 * 查找所有产品的图片
	 * @return
	 * @throws RuntimeException
	 */
	public List<String> findAllPic() throws RuntimeException;
	
	/**
	 * 查行区间内的产品记录
	 * @param begin
	 * @param end
	 * @return
	 * @throws RuntimeException
	 */
	public List<Product> findLimit(int begin, int end) throws RuntimeException;

	/**
	 * 添加产品
	 * @param product
	 * @throws RuntimeException
	 */
	public void add(Product product) throws RuntimeException;

	/**
	 * 更新产品全部信息（包括关联表）
	 * @param product
	 * @throws RuntimeException
	 */
	public void update(Product product) throws RuntimeException;

	/**
	 * 更新产品基本信息（不包括关联表）
	 * @param product
	 * @throws RuntimeException
	 */
	public void updateBase(Product product) throws RuntimeException;

	/**
	 * 删除某个产品
	 * @param product
	 * @throws RuntimeException
	 */
	public void delete(Product product) throws RuntimeException;

	/**
	 * 删除所有产品
	 * @throws RuntimeException
	 */
	public void deleteAll() throws RuntimeException;

	/**
	 * 计算产品总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;

	
}
