package com.jackdaw.service;

import java.util.List;

import com.jackdaw.entity.User;

/**
 * 业务逻辑层接口。处理和用户相关的业务。
 * @author E-Kunt
 *
 */
public interface UserService extends ServiceSupport {

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
	 * 查某页内的用户记录
	 * @param pageNo
	 * @return
	 * @throws RuntimeException
	 */
	public List<User> findInPage(int pageNo) throws RuntimeException;

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
	 * 获得用户总数量
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
	 * 获得每页显示的用户数量
	 * @return
	 * @throws RuntimeException
	 */
	public int getPageRow() throws RuntimeException;
	
	
	/**
	 * 计算用户总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;
	
	/**
	 * 登陆
	 * @param user
	 * @return 成功返回从数据库得到的对应的对象，失败返回null
	 * @throws RuntimeException
	 */
	public User login(User user) throws RuntimeException;
	
	/**
	 * 注册
	 * @param user
	 * @return 成功返回true，失败返回false
	 * @throws RuntimeException
	 */
	public boolean register(User user) throws RuntimeException;
}
