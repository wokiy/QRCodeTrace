package com.jackdaw.action;



import com.jackdaw.entity.Material;
import com.jackdaw.entity.Product;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.MaterialService;
import com.jackdaw.service.ProductService;
import com.jackdaw.service.impl.MaterialServiceImpl;
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
public class MaterialAction extends ActionSupport implements ModelDriven<Material>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1713043174449910942L;

	private MaterialService service = new MaterialServiceImpl();
	private ProductService pro_service = new ProductServiceImpl();
	
	private String pro_id;
	private Material material = new Material();
	
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public Material getModel() {
		return material;
	}
	
	/**
	 * 跳转到 原料_添加输入界面
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
	public String materialSave() {
		Product product = pro_service.getById(pro_id);
		if(product !=null) {
			material.setProduct(product);
		}
		try {
			service.add(material);
			return "materialSuccess";
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
			// int id = product.getMaterial().getId();
			// Material loadMaterial = service.getById(id);
			Material pro_material = product.getMaterial();
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.push(pro_material);
			return INPUT;
		}  catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改方法(点击修改后)
	 */
	public String materialUpdate() {
		try {
			String id = material.getProduct().getId();
			Product product = pro_service.getById(id);
			material.setProduct(product);
			service.update(material);
			return "materialSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 删除
	 */
	public String materialDelete() {
		try {
			Material deleteMaterial = new Material();
			deleteMaterial.setId(material.getId());
			// Material deleteMaterial = service.getById(material.getId());
			service.delete(deleteMaterial);
			return "materialSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
