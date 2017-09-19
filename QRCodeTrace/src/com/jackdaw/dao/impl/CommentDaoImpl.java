package com.jackdaw.dao.impl;

import java.util.List;
import com.jackdaw.dao.CommentDao;
import com.jackdaw.entity.Comment;

/**
 * 留言表数据访问对象
 * @author E-Kunt
 *
 */
public class CommentDaoImpl extends DaoSupportImpl implements CommentDao {

	@Override
	public Comment loadById(int id) throws RuntimeException {
		Comment comment = (Comment) this.getCurrentSession().load(Comment.class, id);
		return comment;
	}

	@Override
	public Comment getById(int id) throws RuntimeException {
		Comment comment = (Comment) this.getCurrentSession().get(Comment.class, id);
		return comment;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAll() throws RuntimeException {
		String hql = "from Comment";
		List<Comment> comments = this.getCurrentSession().createQuery(hql).list();
		return comments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findLimit(int begin, int end) throws RuntimeException {
		String hql = "from Comment order by date desc";
		List<Comment> comments = this.getCurrentSession().createQuery(hql).setFirstResult(begin).setMaxResults(end).list();
		return comments;
	}

	@Override
	public void add(Comment comment) throws RuntimeException {
		this.getCurrentSession().save(comment);
	}

	@Override
	public void update(Comment comment) throws RuntimeException {
		this.getCurrentSession().update(comment);
	}

	@Override
	public void delete(Comment comment) throws RuntimeException {
		this.getCurrentSession().delete(comment);

	}

	@Override
	public void deleteAll() throws RuntimeException {
		String hql= "delete Comment";
		this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public long count() throws RuntimeException {
		String hql = "select count(c) from Comment c";
		long count = (long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return count;
	}

}
