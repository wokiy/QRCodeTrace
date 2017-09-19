package com.jackdaw.action;

import com.jackdaw.entity.Product;
import com.jackdaw.entity.Transport;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.ProductService;
import com.jackdaw.service.TransportService;
import com.jackdaw.service.impl.ProductServiceImpl;
import com.jackdaw.service.impl.TransportServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 
 * @author Sgoldfish
 *
 */
public class TransportAction extends ActionSupport implements ModelDriven<Transport> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8145083230096004735L;
	
	private TransportService service = new TransportServiceImpl();
	private ProductService pro_service = new ProductServiceImpl();
	
	private String pro_id;
	private Transport transport = new Transport();
	
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	@Override
	public Transport getModel() {
		return transport;
	}
	
	/**
	 * 跳转到 运输_添加输入界面
	 */
	public String addInput() {
		ActionContext.getContext().getContextMap().put("pro_id", pro_id);
		return INPUT;
	}
	
	/**
	 * 添加保存(点击添加后)
	 * @return
	 */
	public String transportSave() {
		Product product = pro_service.getById(pro_id);
		if(product !=null) {
			transport.setProduct(product);
		}
		try {
			service.add(transport);
			return "transportSuccess";
		} catch (ServiceException e) {
			ActionContext.getContext().getContextMap().put("msg", e.getMessage());
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改/删除 运输信息页面数据显示(点击详细后)
	 */
	public String updateInput() {
		// 根据传递过来的product获取material,放入值栈,以在页面回显信息
		try {
			Product product = pro_service.getById(pro_id);
			// int id = product.getMaterial().getId();
			// Material loadMaterial = service.getById(id);
			Transport pro_transport = product.getTransport();
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.push(pro_transport);
			return INPUT;
		}  catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改方法(点击修改后)
	 */
	public String transportUpdate() {
		try {
			String id = transport.getProduct().getId();
			Product product = pro_service.getById(id);
			transport.setProduct(product);
			service.update(transport);
			return "transportSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 删除
	 */
	public String transportDelete() {
		try {
			Transport deleteTransport = new Transport();
			deleteTransport.setId(transport.getId());
			// Material deleteMaterial = service.getById(material.getId());
			service.delete(deleteTransport);
			return "transportSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
