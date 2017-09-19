package com.jackdaw.action;

import java.util.Date;
import java.util.List;

import com.jackdaw.entity.Comment;
import com.jackdaw.entity.Company;
import com.jackdaw.entity.Product;
import com.jackdaw.service.CommentService;
import com.jackdaw.service.CompanyService;
import com.jackdaw.service.ProductService;
import com.jackdaw.service.impl.CommentServiceImpl;
import com.jackdaw.service.impl.CompanyServiceImpl;
import com.jackdaw.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 
 * @author Sgoldfish
 *
 */
public class CommentAction extends ActionSupport implements ModelDriven<Comment>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8577914894226235277L;
	/**
	 * 
	 */
	// 当前页
	private int pageNo;
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	private Comment comment = new Comment();
	private CommentService service = new CommentServiceImpl();
	private ProductService pro_service = new ProductServiceImpl();
	private CompanyService companyService = new CompanyServiceImpl();
	private String pro_id;

	public Comment getComment() {
		return comment;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}


	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	@Override
	public Comment getModel() {
		return comment;
	}
	
	/**
	 * 跳转到全留言管理页
	 */
	public String commentInfoShow() {
		try {
			if(pageNo <= 0) {
				pageNo = 1;
			}
			List<Comment> commentList = service.findInPage(pageNo);
			Company companyInfo = companyService.getById(1);
			int totalPage = service.getTotalPage();
			int totalRow = service.getTotalRow();
			int pageRow = service.getPageRow();
			ActionContext.getContext().getContextMap().put("pageRow", pageRow);
			ActionContext.getContext().getContextMap().put("totalPage", totalPage);
			ActionContext.getContext().getContextMap().put("totalRow", totalRow);
			ActionContext.getContext().getContextMap().put("pageNo", pageNo);
			// List<Comment> commentList = service.findAll();
			ActionContext.getContext().getContextMap().put("commentList", commentList);
			ActionContext.getContext().getContextMap().put("companyInfo", companyInfo);
			return SUCCESS;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改/删除页面数据显示(点击详细后)
	 */
	public String updateInput() {
		try {
			Comment commentInfo = service.getById(comment.getId());
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.push(commentInfo);
			return INPUT;
		}  catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 跳转到 留言_添加输入界面
	 */
	public String addInput() {
		try {
			ActionContext.getContext().getContextMap().put("pro_id", pro_id);
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 添加保存(点击添加后)
	 * @return
	 */
	public String commentSave() {
		try {
			Product product = pro_service.getById(pro_id);
			if(product !=null) {
				comment.setProduct(product);
			} else {
				ActionContext.getContext().getSession().put("commentMsg", "追溯码不存在");
				return "commentFailed";
			}
			comment.setDate(new Date());
			service.add(comment);
			return "commentSuccess";
		}  catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	/**
	 * 修改方法(点击修改后)
	 */
	public String commentUpdate() {
		try {
			// sell里根据传过来的pro_id 已经封装好了product
			String id = comment.getProduct().getId();
			Product product = pro_service.getById(id);
			comment.setProduct(product);
			service.update(comment);
			return "commentSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 删除
	 */
	public String commentDelete() {
		try {

			Comment deleteComment = new Comment();
			deleteComment.setId(comment.getId());
			service.delete(deleteComment);
			return "commentSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
