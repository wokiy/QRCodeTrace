package com.jackdaw.dao;

import java.util.List;

import com.jackdaw.entity.User;

/**
 * 用户表数据访问对象接口
 * @author E-Kunt
 *
 */
public interface UserDao extends DaoSupport {

	/**
	 * 通过userName取数据
	 * @param userName
	 * @return
	 * @throws RuntimeException
	 */
	public User getByUserName(String userName) throws RuntimeException;
	
	/**
	 * 根据realName搜索用户数据
	 * @param realName
	 * @return
	 * @throws RuntimeException
	 */
	public List<User> getByRealName(String realName) throws RuntimeException;
	

	/**
	 * 获得所有用户信息
	 * @return
	 * @throws RuntimeException
	 */
	public List<User> findAll() throws RuntimeException;
	
	/**
	 * 查行区间内的用户记录
	 * @param begin
	 * @param end
	 * @return
	 * @throws RuntimeException
	 */
	public List<User> findLimit(int begin, int end) throws RuntimeException;

	/**
	 * 添加用户
	 * @param user
	 * @throws RuntimeException
	 */
	public void add(User user) throws RuntimeException;
	
	/**
	 * 更新用户全部信息
	 * @param user
	 * @throws RuntimeException
	 */
	public void update(User user) throws RuntimeException;
	
	/**
	 * 更新用户密码
	 * @param user
	 * @throws RuntimeException
	 */
	public void updatePassword(User user) throws RuntimeException;
	
	/**
	 * 更新用户权限级别
	 * 0:material
	 * 1:process
	 * 2.transport
	 * 3.sell
	 * >4 all
	 * @param user
	 * @throws RuntimeException
	 */
	public void updateRole(User user) throws RuntimeException;
	
	/**
	 * 删除某个用户
	 * @param user
	 * @throws RuntimeException
	 */
	public void delete(User user) throws RuntimeException;
	
	/**
	 * 计算用户总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;
}
