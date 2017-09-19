package com.jackdaw.service;

import java.util.List;
import com.jackdaw.entity.Comment;

/**
 * 业务逻辑层接口。处理和公司资料相关的业务。
 * @author E-Kunt
 *
 */
public interface CommentService extends ServiceSupport{

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
	 * 查找一条留言  立即加载
	 * @param comment
	 * @return
	 * @throws RuntimeException
	 */
	public Comment get(Comment comment) throws RuntimeException;

	/**
	 * 查找所有留言
	 * @return
	 * @throws RuntimeException
	 */
	public List<Comment> findAll() throws RuntimeException;

	
	/**
	 * 查某页内的留言记录
	 * @param pageNo
	 * @return
	 * @throws RuntimeException
	 */
	public List<Comment> findInPage(int pageNo) throws RuntimeException;

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
	 * 计算留言总数量
	 * @return
	 * @throws RuntimeException
	 */
	public long count() throws RuntimeException;
	/**
	 * 获得留言总数量
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
	 * 获得每页显示的留言数量
	 * @return
	 * @throws RuntimeException
	 */
	public int getPageRow() throws RuntimeException;
	
}
