package com.jackdaw.dao.impl;

import java.util.Date;
import java.util.List;

import com.jackdaw.dao.NewsDao;
import com.jackdaw.entity.News;

/**
 * 新闻表数据访问对象
 * @author E-Kunt
 *
 */
public class NewsDaoImpl extends DaoSupportImpl implements NewsDao {

	@Override
	public News loadById(int id) throws RuntimeException {
		News news = (News) this.getCurrentSession().load(News.class, id);
		return news;
	}

	@Override
	public News getById(int id) throws RuntimeException {
		News news = (News) this.getCurrentSession().get(News.class, id);
		return news;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getByTitle(String title) throws RuntimeException {
		String hql = "from News n where n.title like :title";
		List<News> news = this.getCurrentSession().createQuery(hql).setParameter("title", "%" + title + "%")
				.list();
		return news;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> seachByKeyword(String keyword) throws RuntimeException {
		String hql = "from News n where n.title like :title or n.content like :content";
		List<News> news = this.getCurrentSession().createQuery(hql).setParameter("title", "%" + keyword + "%").setParameter("content", "%" + keyword + "%")
				.list();
		return news;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> findAll() throws RuntimeException {
		String hql = "from News";
		List<News> newses = this.getCurrentSession().createQuery(hql).list();
		return newses;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<News> findLimit(int begin, int end) throws RuntimeException {
		String hql = "from News order by date desc";
		List<News> newses = this.getCurrentSession().createQuery(hql).setFirstResult(begin).setMaxResults(end).list();
		return newses;
	}

	@Override
	public void add(News news) throws RuntimeException {
		this.getCurrentSession().save(news);

	}

	@Override
	public void update(News news) throws RuntimeException {
		this.getCurrentSession().update(news);

	}

	@Override
	public void delete(News news) throws RuntimeException {
		this.getCurrentSession().delete(news);

	}

	@Override
	public void deleteAll() throws RuntimeException {
		String hql= "delete News";
		this.getCurrentSession().createQuery(hql).executeUpdate();

	}

	@Override
	public long count() throws RuntimeException {
		String hql = "select count(n) from News n";
		long count = (long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public News findPreNews(Date date) throws RuntimeException {
		String sql = "from News where date > ? order by date desc";
		List<News> newsList = this.getCurrentSession().createQuery(sql).setParameter(0, date).list();
		if(newsList != null && newsList.size() > 0) {
			return newsList.get(newsList.size()-1);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public News findNextNews(Date date) throws RuntimeException {
		String sql = "from News where date < ? order by date desc";
		List<News> newsList = this.getCurrentSession().createQuery(sql).setParameter(0, date).list();
		if(newsList != null && newsList.size() > 0) {
				return newsList.get(0);
		} else {
			return null;
		}
	}
}
