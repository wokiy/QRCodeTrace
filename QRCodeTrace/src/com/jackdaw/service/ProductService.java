package com.jackdaw.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;

import com.google.zxing.WriterException;
import com.jackdaw.entity.Material;
import com.jackdaw.entity.Process;
import com.jackdaw.entity.Product;
import com.jackdaw.entity.Project;
import com.jackdaw.entity.Sell;
import com.jackdaw.entity.Transport;

/**
 * 业务逻辑层接口。处理和产品相关的业务。
 * @author E-Kunt
 *
 */
public interface ProductService extends ServiceSupport {

	/**
	 * 通过ID查找一个产品 延迟加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Product loadById(String id) throws RuntimeException;
	
	/**
	 * 通过ID查找一个产品 立即加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Product getById(String id) throws RuntimeException;

	/**
	 * 查找一个产品 立即加载
	 * @param product
	 * @return
	 * @throws RuntimeException
	 */
	public Product get(Product product) throws RuntimeException;

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
	 * 查某页的产品记录
	 * @param pageNo
	 * @return
	 * @throws RuntimeException
	 */
	public List<Product> findInPage(int pageNo) throws RuntimeException;
	
	/**
	 * 添加产品
	 * @param project
	 * @param product
	 * @throws RuntimeException
	 */
	public void add(Project project, Product product) throws RuntimeException;
	
	/**
	 * 更新产品全部信息（包括关联表）
	 * @param product
	 * @throws RuntimeException
	 */
	public void update(Product product) throws RuntimeException;

	/**
	 * 只更新产品名称和图片
	 * @param product
	 * @throws RuntimeException
	 */
	public void updateBase(Product product) throws RuntimeException;

	/**
	 * 只更新产品原料信息
	 * @param product
	 * @param material
	 * @throws RuntimeException
	 */
	public void updateMaterial(Product product,Material material) throws RuntimeException;

	/**
	 * 只更新产品加工信息
	 * @param product
	 * @param process
	 * @throws RuntimeException
	 */
	public void updateProcess(Product product, Process process) throws RuntimeException;

	/**
	 * 只更新产品运输信息
	 * @param product
	 * @param transport
	 * @throws RuntimeException
	 */
	public void updateTransport(Product product, Transport transport) throws RuntimeException;

	/**
	 * 只更新产品销售信息
	 * @param product
	 * @param sell
	 * @throws RuntimeException
	 */
	public void updateSell(Product product, Sell sell) throws RuntimeException;

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
	
	/**
	 * 获得产品总数量
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
	 * 获得每页显示的产品数量
	 * @return
	 * @throws RuntimeException
	 */
	public int getPageRow() throws RuntimeException;
	

	/**
	 * 生成二维码
	 * @param request
	 * @param productId
	 * @throws WriterException
	 * @throws IOException
	 */
	public void createQRCode(ServletRequest request, String productId,String dir) throws WriterException, IOException;
}
