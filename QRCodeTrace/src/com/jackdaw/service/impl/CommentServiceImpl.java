package com.jackdaw.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import com.jackdaw.dao.CommentDao;
import com.jackdaw.dao.impl.CommentDaoImpl;
import com.jackdaw.entity.Comment;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.CommentService;

/**
 * 业务逻辑层。处理和留言相关的业务。
 * @author E-Kunt
 *
 */
public class CommentServiceImpl extends ServiceSupportImpl implements CommentService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(CommentServiceImpl.class);
	/**
	 * 产品原料数据访问对象
	 */
	private CommentDao commentDao = new CommentDaoImpl();
	/**
	 * 分页显示时，每页多少条记录
	 */
	private final int PAGE_ROW = 8;
	
	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, commentDao);
	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, commentDao);
	}

	@Override
	public Comment loadById(int id) throws RuntimeException {
		Comment comment = null;
		LOG.info("尝试通过ID加载一条留言。");
		comment = commentDao.loadById(id);
		return comment;
	}

	@Override
	public Comment getById(int id) throws RuntimeException {
		Comment comment = null;
		LOG.info("尝试通过ID获得一条留言。");
		comment = commentDao.getById(id);
		return comment;
	}
	
	@Override
	public Comment get(Comment comment) throws RuntimeException {
		return getById(comment.getId());
	}

	@Override
	public List<Comment> findAll() throws RuntimeException {
		List<Comment> comments = null;
		LOG.info("尝试获得所有留言。");
		comments = commentDao.findAll();
		return comments;
	}

	@Override
	public List<Comment> findInPage(int pageNo) throws RuntimeException {
		List<Comment> comments = null;
		LOG.info("尝试获得第"+ pageNo +"页所有的留言。");
		// 留言表记录的总数量
		int totalRows = (int) commentDao.count();
		// 显示所有留言一共需要多少页
		int totalPages = (totalRows + PAGE_ROW - 1) / PAGE_ROW;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > totalPages) {
			pageNo = totalPages;
		}
		comments = commentDao.findLimit((pageNo - 1) * PAGE_ROW, PAGE_ROW);
		return comments;
	}

	@Override
	public void add(Comment comment) throws RuntimeException {
		LOG.info("尝试添加一条留言。");
		if (commentDao.getById(comment.getId()) != null) {
			LOG.error("添加留言失败，该留言已存在。");
			throw new ServiceException("添加留言失败，该留言已存在。");
		}
		commentDao.add(comment);

	}

	@Override
	public void update(Comment comment) throws RuntimeException {
		LOG.info("尝试更新一条留言。");
		if (commentDao.getById(comment.getId()) == null) {
			LOG.error("更新留言失败，该留言不存在。");
			throw new ServiceException("更新留言失败，该留言不存在。");
		}
		commentDao.clearSession();
		commentDao.update(comment);
	}

	@Override
	public void delete(Comment comment) throws RuntimeException {
		LOG.info("尝试删除一条留言。");
		commentDao.delete(comment);

	}

	@Override
	public void deleteAll() throws RuntimeException {
		LOG.info("尝试删除所有留言。");
		commentDao.deleteAll();

	}

	@Override
	public long count() throws RuntimeException {
		long count = 0;
		LOG.info("尝试获得所有留言的数量。");
		count = commentDao.count();
		return count;
	}

	@Override
	public int getTotalRow() throws RuntimeException {
		return (int) commentDao.count();
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
