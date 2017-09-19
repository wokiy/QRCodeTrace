package com.jackdaw.action;

import com.jackdaw.entity.Product;
import com.jackdaw.entity.Sell;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.ProductService;
import com.jackdaw.service.SellService;
import com.jackdaw.service.impl.ProductServiceImpl;
import com.jackdaw.service.impl.SellServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 
 * @author Sgoldfish
 *
 */
public class SellAction extends ActionSupport implements ModelDriven<Sell> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7504539258720765679L;
	private SellService service = new SellServiceImpl();
	private ProductService pro_service = new ProductServiceImpl();
	
	private Sell sell = new Sell();
	private String pro_id;

	public Sell getSell() {
		return sell;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	@Override
	public Sell getModel() {
		return sell;
	}
	
	/**
	 * 跳转到 销售_添加输入界面
	 */
	public String addInput() {
		ActionContext.getContext().getContextMap().put("pro_id", pro_id);
		return INPUT;
	}
	
	/**
	 * 添加保存(点击添加后)
	 * @return
	 */
	public String sellSave() {
		Product product = pro_service.getById(pro_id);
		if(product !=null) {
			sell.setProduct(product);
		}
		try {
			service.add(sell);
			return "sellSuccess";
		} catch (ServiceException e) {
			ActionContext.getContext().getContextMap().put("msg", e.getMessage());
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改/删除页面数据显示(点击详细后)
	 */
	public String updateInput() {
		// 根据传递过来的product获取material,放入值栈,以在页面回显信息
		try {
			Product product = pro_service.getById(pro_id);
			Sell pro_sell = product.getSell();
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.push(pro_sell);
			return INPUT;
		}  catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改方法(点击修改后)
	 */
	public String sellUpdate() {
		try {
			// sell里根据传过来的pro_id 已经封装好了product
			String id = sell.getProduct().getId();
			Product product = pro_service.getById(id);
			sell.setProduct(product);
			service.update(sell);
			return "sellSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 删除
	 */
	public String sellDelete() {
		try {

			Sell deleteSell = new Sell();
			deleteSell.setId(sell.getId());
			service.delete(deleteSell);
			return "sellSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
