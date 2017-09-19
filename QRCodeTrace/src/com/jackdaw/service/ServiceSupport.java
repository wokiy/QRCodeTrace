package com.jackdaw.service;

import java.util.List;

import com.jackdaw.dao.DaoSupport;

/**
 * 业务逻辑层支持接口
 * @author E-Kunt
 *
 */
public interface ServiceSupport {

	/**
	 * 使用sql更新、删除、插入
	 * @param sql
	 * @param dao
	 * @throws RuntimeException
	 */
	public void sqlDml(String sql, DaoSupport dao) throws RuntimeException;
	
	/**
	 * 使用sql更新、删除、插入
	 * @param sql
	 * @throws RuntimeException
	 */
	public void sqlDml(String sql) throws RuntimeException;
	
	/**
	 * 使用sql查询
	 * @param sql
	 * @param dao
	 * @return
	 * @throws RuntimeException
	 */
	public List<Object[]> sqlDql(String sql, DaoSupport dao) throws RuntimeException;

	/**
	 * 使用sql查询
	 * @param sql
	 * @return
	 * @throws RuntimeException
	 */
	public List<Object[]> sqlDql(String sql) throws RuntimeException;
	
}
