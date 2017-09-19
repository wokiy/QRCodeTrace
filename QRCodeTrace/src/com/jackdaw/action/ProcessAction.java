package com.jackdaw.action;


import com.jackdaw.entity.Process;
import com.jackdaw.entity.Product;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.ProcessService;
import com.jackdaw.service.ProductService;
import com.jackdaw.service.impl.ProcessServiceImpl;
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
public class ProcessAction extends ActionSupport implements ModelDriven<Process> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4402373079979203341L;
	
	private ProcessService service = new ProcessServiceImpl();
	private ProductService pro_service = new ProductServiceImpl();
	
	private String pro_id;
	Process process = new Process();
	
	public Process getProcess() {
		return process;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	@Override
	public Process getModel() {
		return process;
	}
	
	/**
	 * 跳转到 加工_添加
	 */
	public String addInput() {
		ActionContext.getContext().getContextMap().put("pro_id", pro_id);
		return INPUT;
	}
	
	/**
	 * 添加保存(点击添加后)
	 * @return
	 */
	public String processSave() {
		Product product = pro_service.getById(pro_id);
		if(product !=null) {
			process.setProduct(product);
		}
		try {
			service.add(process);
			return "processSuccess";
		} catch (ServiceException e) {
			ActionContext.getContext().getContextMap().put("msg", e.getMessage());
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改/删除 加工信息页面数据显示(点击详细后)
	 */
	public String updateInput() {
		// 根据传递过来的product获取material,放入值栈,以在页面回显信息
		try {
			Product product = pro_service.getById(pro_id);
			// int id = product.getMaterial().getId();
			// Material loadMaterial = service.getById(id);
			Process pro_process = product.getProcess();
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.push(pro_process);
			return INPUT;
		}  catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改方法(点击修改后)
	 */
	public String processUpdate() {
		try {
			String id = process.getProduct().getId();
			Product product = pro_service.getById(id);
			process.setProduct(product);
			service.update(process);
			return "processSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 删除
	 */
	public String processDelete() {
		try {
//			String id = material.getProduct().getId();
//			Product product = pro_service.getById(id);
//			material.setProduct(product);
			Process deleteProcess = new Process();
			deleteProcess.setId(process.getId());
			service.delete(deleteProcess);
			return "processSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
