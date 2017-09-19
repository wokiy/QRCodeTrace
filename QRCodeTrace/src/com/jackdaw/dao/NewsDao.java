package com.jackdaw.dao;

import java.util.Date;
import java.util.List;

import com.jackdaw.entity.News;

/**
 * 新闻表数据访问对象接口
 * @author E-Kunt
 *
 */
public interface NewsDao extends DaoSupport{

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
	 * 查行区间内的新闻记录
	 * @param begin
	 * @param end
	 * @return
	 * @throws RuntimeException
	 */
	public List<News> findLimit(int begin, int end) throws RuntimeException;
	
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
	 * 查找上一篇新闻
	 */
	public News findPreNews(Date date) throws RuntimeException;
	
	/**
	 * 查找下一篇新闻
	 */
	public News findNextNews(Date date) throws RuntimeException;
	
}
