package com.jackdaw.dao;

import java.util.List;
import com.jackdaw.entity.Comment;

/**
 * 留言表数据访问对象接口
 * @author E-Kunt
 *
 */
public interface CommentDao extends DaoSupport{

	/**
	 * 通过ID查找一条留言 延迟加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Comment loadById(int id) throws RuntimeException;
	/**
	 * 通过ID查找一条留言 立即加载
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	public Comment getById(int id) throws RuntimeException;

	/**
	 * 查找所有留言
	 * @return
	 * @throws RuntimeException
	 */
	public List<Comment> findAll() throws RuntimeException;

	
	/**
	 * 查行区间内的留言记录
	 * @param begin
	 * @param end
	 * @return
	 * @throws RuntimeException
	 */
	public List<Comment> findLimit(int begin, int end) throws RuntimeException;
	
	/**
	 * 添加留言
	 * @param comment
	 * @throws RuntimeException
	 */
	public void add(Comment comment) throws RuntimeException;
	
	/**
	 * 更新留言
	 * @param comment
	 * @throws RuntimeException
	 */
	public void update(Comment comment) throws RuntimeException;
	
	/**
	 * 删除某条留言
	 * @param comment
	 * @throws RuntimeException
	 */
	public void delete(Comment comment) throws RuntimeException;
	
	/**
	 * 删除所有留言
	 * @throws RuntimeException
	 */
	public void deleteAll() throws RuntimeException;

	/**
	 * 计算留言表记录总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;
	
}
