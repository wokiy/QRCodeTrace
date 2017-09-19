package com.jackdaw.dao;

import java.util.List;

import org.hibernate.Session;

/**
 * 基本数据访问对象接口，提供基本方法的定义
 * @author E-Kunt
 *
 */
public interface DaoSupport {
	/**
	 * 获取当前的session
	 * @return
	 * @throws RuntimeException
	 */
	public Session getCurrentSession() throws RuntimeException;
	
	/**
	 * 清除当前的session缓存
	 * @return
	 * @throws RuntimeException
	 */
	public void clearSession() throws RuntimeException;
	
	/**
	 * 使用sql更新、删除、插入
	 * @param sql
	 * @throws RuntimeException
	 */
	public void sqlDml(String sql) throws RuntimeException;
	
	/**
	 * 使用sql查询
	 * @param sql
	 * @return
	 * @throws RuntimeException
	 */
	public List<Object[]> sqlDql(String sql) throws RuntimeException;
}
