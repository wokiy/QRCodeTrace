package com.jackdaw.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.jackdaw.dao.NewsDao;
import com.jackdaw.dao.impl.NewsDaoImpl;
import com.jackdaw.entity.News;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.NewsService;

/**
 * 业务逻辑层。处理和新闻相关的业务。
 * @author E-Kunt
 *
 */
public class NewsServiceImpl extends ServiceSupportImpl implements NewsService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(NewsServiceImpl.class);
	/**
	 * 新闻数据访问对象
	 */
	private NewsDao newsDao = new NewsDaoImpl();
	/**
	 * 分页显示时，每页多少条记录
	 */
	private final int PAGE_ROW = 10;
	
	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, newsDao);
	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, newsDao);
	}

	@Override
	public News loadById(int id) throws RuntimeException {
		News news = null;
		LOG.info("尝试通过ID加载一条新闻。");
		news = newsDao.loadById(id);
		return news;
	}

	@Override
	public News getById(int id) throws RuntimeException {
		News news = null;
		LOG.info("尝试通过ID获得一条新闻。");
		news = newsDao.getById(id);
		return news;
	}

	@Override
	public News get(News news) throws RuntimeException {
		return getById(news.getId());
	}

	@Override
	public List<News> getByTitle(String title) throws RuntimeException {
		List<News> news = null;
		LOG.info("尝试通过标题加载一条新闻。");
		news = newsDao.getByTitle(title);
		return news;
	}

	@Override
	public List<News> seachByKeyword(String keyword) throws RuntimeException {
		List<News> news = null;
		LOG.info("尝试通过关键词搜索一条新闻。");
		news = newsDao.seachByKeyword(keyword);
		return news;
	}

	@Override
	public List<News> findAll() throws RuntimeException {
		List<News> news = null;
		LOG.info("尝试获得所有新闻。");
		news = newsDao.findAll();
		return news;
	}

	@Override
	public List<News> findInPage(int pageNo) throws RuntimeException {
		List<News> news = null;
		LOG.info("尝试获得第"+ pageNo +"页所有的新闻。");
		// 新闻表记录的总数量
		int totalRows = (int) newsDao.count();
		// 显示所有新闻一共需要多少页
		int totalPages = (totalRows + PAGE_ROW - 1) / PAGE_ROW;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > totalPages) {
			pageNo = totalPages;
		}
		news = newsDao.findLimit((pageNo - 1) * PAGE_ROW, PAGE_ROW);
		return news;
	}

	@Override
	public void add(News news) throws RuntimeException {
		LOG.info("尝试添加一条新闻。");
		if (newsDao.getById(news.getId()) != null) {
			LOG.error("添加新闻失败，该新闻已存在。");
			throw new ServiceException("添加新闻失败，该新闻已存在。");
		}
		newsDao.add(news);

	}

	@Override
	public void update(News news) throws RuntimeException {
		LOG.info("尝试更新一条新闻。");
		if (newsDao.getById(news.getId()) == null) {
			LOG.error("更新新闻失败，该新闻不存在。");
			throw new ServiceException("更新新闻失败，该新闻不存在。");
		}
		newsDao.clearSession();
		newsDao.update(news);

	}

	@Override
	public void delete(News news) throws RuntimeException {
		LOG.info("尝试删除一条新闻。");
		newsDao.delete(news);
	}

	@Override
	public void deleteAll() throws RuntimeException {
		LOG.info("尝试删除所有新闻。");
		newsDao.deleteAll();
	}

	@Override
	public long count() throws RuntimeException {
		long count = 0;
		LOG.info("尝试获得所有新闻的数量。");
		count = newsDao.count();
		return count;
	}

	@Override
	public int getTotalRow() throws RuntimeException {
		return (int) newsDao.count();
	}

	@Override
	public int getTotalPage() throws RuntimeException {
		return (getTotalRow() + getPageRow() - 1) / getPageRow();
	}

	@Override
	public int getPageRow() throws RuntimeException {
		return PAGE_ROW;
	}

	@Override
	public News getPreNews(Date date) throws RuntimeException {
		return newsDao.findPreNews(date);
	}

	@Override
	public News getNextNews(Date date) throws RuntimeException {
		return newsDao.findNextNews(date);
	}
}
