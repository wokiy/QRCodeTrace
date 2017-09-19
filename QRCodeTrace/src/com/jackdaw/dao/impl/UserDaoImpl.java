package com.jackdaw.dao.impl;

import java.util.List;

import com.jackdaw.dao.UserDao;
import com.jackdaw.entity.User;

/**
 * 用户表数据访问对象
 * @author E-Kunt
 *
 */
public class UserDaoImpl extends DaoSupportImpl implements UserDao {

	@Override
	public User getByUserName(String userName) throws RuntimeException {
		User user = (User) this.getCurrentSession().get(User.class, userName);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByRealName(String realName) throws RuntimeException {
		String hql = "from User u where u.realName like :name";
		List<User> users = this.getCurrentSession().createQuery(hql).setParameter("name", "%" + realName + "%")
				.list();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() throws RuntimeException {
		String hql = "from User";
		List<User> users = this.getCurrentSession().createQuery(hql).list();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findLimit(int begin, int end) throws RuntimeException {
		String hql = "from User";
		List<User> users = this.getCurrentSession().createQuery(hql).setFirstResult(begin).setMaxResults(end)
				.list();
		return users;
	}

	@Override
	public void add(User user) throws RuntimeException {
		this.getCurrentSession().save(user);
		
	}

	@Override
	public void update(User user) throws RuntimeException {
		this.getCurrentSession().update(user);
	}

	@Override
	public void updatePassword(User user) throws RuntimeException {
		String hql = "update User u set u.password = ? where u.userName = ?";
		this.getCurrentSession().createQuery(hql).setParameter(0, user.getPassword()).setParameter(1, user.getUserName()).executeUpdate();
	}

	@Override
	public void updateRole(User user) throws RuntimeException {
		String hql = "update User u set u.role = ? where u.userName = ?";
		this.getCurrentSession().createQuery(hql).setParameter(0, user.getRole()).setParameter(1, user.getUserName()).executeUpdate();
	}

	@Override
	public void delete(User user) throws RuntimeException {
		this.getCurrentSession().delete(user);
	}

	@Override
	public long count() throws RuntimeException {
		String hql = "select count(u) from User u";
		long count = (long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return count;
	}

}
