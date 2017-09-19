package com.jackdaw.service;

import java.util.Date;
import java.util.List;

import com.jackdaw.entity.News;

/**
 * 业务逻辑层接口。处理和新闻相关的业务。
 * @author E-Kunt
 *
 */
public interface NewsService extends ServiceSupport{

	/**
	 * 通过ID查找一条新闻 延迟加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public News loadById(int id) throws RuntimeException;
	
	/**
	 * 通过ID查找一条新闻 立即加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public News getById(int id) throws RuntimeException;
	
	/**
	 * 查找一条新闻 立即加载
	 * @param news
	 * @return
	 * @throws RuntimeException
	 */
	public News get(News news) throws RuntimeException;
	
	/**
	 * 通过标题查找新闻
	 * @param title
	 * @return
	 * @throws RuntimeException
	 */
	public List<News> getByTitle(String title) throws RuntimeException;

	/**
	 * 通过关键字查找新闻
	 * @param keyword
	 * @return
	 * @throws RuntimeException
	 */
	public List<News> seachByKeyword(String keyword) throws RuntimeException;
	
	/**
	 * 查找所有新闻
	 * @return
	 * @throws RuntimeException
	 */
	public List<News> findAll() throws RuntimeException;
	
	/**
	 * 查某页内的新闻记录
	 * @param pageNo
	 * @return
	 * @throws RuntimeException
	 */
	public List<News> findInPage(int pageNo) throws RuntimeException;
	
	/**
	 * 添加新闻
	 * @param news
	 * @throws RuntimeException
	 */
	public void add(News news) throws RuntimeException;
	
	/**
	 * 更新新闻全部信息
	 * @param news
	 * @throws RuntimeException
	 */
	public void update(News news) throws RuntimeException;

	/**
	 * 删除某条新闻
	 * @param news
	 * @throws RuntimeException
	 */
	public void delete(News news) throws RuntimeException;
	
	/**
	 * 删除所有新闻
	 * @throws RuntimeException
	 */
	public void deleteAll() throws RuntimeException;

	/**
	 * 计算新闻总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;
	
	/**
	 * 获得新闻总数量
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
	 * 获得每页显示的新闻数量
	 * @return
	 * @throws RuntimeException
	 */
	public int getPageRow() throws RuntimeException;
	
	/**
	 * 获取上一篇新闻
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public News getPreNews(Date date) throws RuntimeException;
	
	/**
	 * 获取下一篇新闻
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public News getNextNews(Date date) throws RuntimeException;
}
