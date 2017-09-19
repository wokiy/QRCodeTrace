package com.jackdaw.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import com.jackdaw.dao.UserDao;
import com.jackdaw.dao.impl.UserDaoImpl;
import com.jackdaw.entity.User;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.UserService;

public class UserServiceImpl extends ServiceSupportImpl implements UserService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);
	/**
	 * 用户数据访问对象
	 */
	private UserDao userDao = new UserDaoImpl();
	/**
	 * 分页显示时，每页多少条记录
	 */
	private final int PAGE_ROW = 10;
	
	
	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, userDao);
	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, userDao);
	}

	@Override
	public User getByUserName(String userName) throws RuntimeException {
		User user = null;
		LOG.info("尝试通过用户名获得一个用户。");
		user = userDao.getByUserName(userName);
		return user;
	}

	@Override
	public List<User> getByRealName(String realName) throws RuntimeException {
		List<User> users = null;
		LOG.info("尝试通过真实姓名搜索用户。");
		users = userDao.getByRealName(realName);
		return users;
	}

	@Override
	public List<User> findAll() throws RuntimeException {
		List<User> users = null;
		LOG.info("尝试获得所有用户信息。");
		users = userDao.findAll();
		return users;
	}

	@Override
	public List<User> findInPage(int pageNo) throws RuntimeException {
		List<User> users = null;
		LOG.info("尝试获得第"+ pageNo +"页所有的用户信息。");
		// 用户表记录的总数量
		int totalRows = (int) userDao.count();
		// 显示所有用户一共需要多少页
		int totalPages = (totalRows + PAGE_ROW - 1) / PAGE_ROW;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > totalPages) {
			pageNo = totalPages;
		}
		users = userDao.findLimit((pageNo - 1) * PAGE_ROW, PAGE_ROW);
		return users;
	}

	@Override
	public void add(User user) throws RuntimeException {
		LOG.info("尝试添加一个用户。");
		if (userDao.getByUserName(user.getUserName()) != null) {
			LOG.error("添加用户失败，该用户已存在。");
			throw new ServiceException("添加用户失败，该用户已存在。");
		}
		userDao.add(user);
	}

	@Override
	public void update(User user) throws RuntimeException {
		LOG.info("尝试更新一个用户。");
		if (userDao.getByUserName(user.getUserName()) == null) {
			LOG.error("更新用户失败，该用户不存在。");
			throw new ServiceException("更新用户失败，该用户不存在。");
		}
		userDao.clearSession();
		userDao.update(user);
	}

	@Override
	public void updatePassword(User user) throws RuntimeException {
		LOG.info("尝试更新某用户密码。");
		if (userDao.getByUserName(user.getUserName()) == null) {
			LOG.error("更新用户密码失败，该用户不存在。");
			throw new ServiceException("更新用户密码失败，该用户不存在。");
		}
		userDao.updatePassword(user);

	}

	@Override
	public void updateRole(User user) throws RuntimeException {
		LOG.info("尝试更新某用户权限。");
		if (userDao.getByUserName(user.getUserName()) == null) {
			LOG.error("更新用户权限失败，该用户不存在。");
			throw new ServiceException("更新用户权限失败，该用户不存在。");
		}
		userDao.updateRole(user);

	}

	@Override
	public void delete(User user) throws RuntimeException {
		LOG.info("尝试添加一个用户。");
		userDao.delete(user);
	}

	@Override
	public long count() throws RuntimeException {
		long count = 0;
		LOG.info("尝试获得所有用户的数量。");
		count = userDao.count();
		return count;
	}

	@Override
	public User login(User user) throws RuntimeException {
		LOG.info("尝试登陆一个用户。");
		User u = getByUserName(user.getUserName());
		if(u != null && u.getPassword().trim().equals(user.getPassword().trim())
				&& u.getRole() == user.getRole()) {
			return u;
		}
		return null;
	}

	@Override
	public boolean register(User user) throws RuntimeException {
		LOG.info("尝试注册一个用户。");
		if(user.getPassword() == null || user.getPassword().trim().equals("")) {
			return false;
		}
		add(user);
		return true;
	}

	@Override
	public int getTotalRow() throws RuntimeException {
		return (int) userDao.count();
	}

	@Override
	public int getTotalPage() throws RuntimeException {
		return (getTotalRow() + getPageRow() - 1) / getPageRow();
	}

	@Override
	public int getPageRow() throws RuntimeException {
		return PAGE_ROW;
	}

}
