package com.jackdaw.action;

import java.util.List;

import com.jackdaw.entity.Project;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.ProjectService;
import com.jackdaw.service.impl.ProjectServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author Sgoldfish
 *
 */
public class ProjectAction extends ActionSupport implements ModelDriven<Project>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3091303091247672316L;
	
	// 当前页
	private int pageNo;
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	private Project project = new Project();
	private ProjectService service = new ProjectServiceImpl();

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public Project getModel() {
		return project;
	}
	
	/**
	 * 跳转到 商品项目
	 */
	public String projectInfoShow() {
		try {
			if(pageNo <= 0) {
				pageNo = 1;
			}
			List<Project> projectList = service.findInPage(pageNo);
			int totalPage = service.getTotalPage();
			int totalRow = service.getTotalRow();
			int pageRow = service.getPageRow();
			ActionContext.getContext().getContextMap().put("pageRow", pageRow);
			ActionContext.getContext().getContextMap().put("totalPage", totalPage);
			ActionContext.getContext().getContextMap().put("totalRow", totalRow);
			ActionContext.getContext().getContextMap().put("pageNo", pageNo);
			// List<Project> projectList = service.getAll();
			ActionContext.getContext().getContextMap().put("projectList", projectList);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 跳转到 商品项目输入
	 */
	public String addInput() {
		try {
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 商品项目添加
	 * @return
	 */
	public String projectSave() {
		try {
			service.add(project);
			return "projectSuccess";
		} catch (ServiceException e) {
			ActionContext.getContext().getContextMap().put("msg", e.getMessage());
			return "projectAddFail";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 跳转到商品修改界面 
	 */
	
	public String updateInput() {
		try {
			Project projectInfo = service.getById(project.getId());
			ActionContext.getContext().getValueStack().push(projectInfo);
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String projectUpdate() {
		try {
			service.update(project);
			return "projectSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String projectDelete() {
		try {
			Project deleteProject = service.getById(project.getId());
			service.delete(deleteProject);
			return "projectSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 根据产品项目名查找
	 */
	public String projectSearch() {
		try {
			if(project !=null) {
				List<Project> projectList = service.getByName(project.getName());
				
				int totalRow = projectList.size();
				int pageRow = service.getPageRow();
				int totalPage = projectList.size() / pageRow;
				ActionContext.getContext().getContextMap().put("pageRow", pageRow);
				ActionContext.getContext().getContextMap().put("totalPage", totalPage);
				ActionContext.getContext().getContextMap().put("totalRow", totalRow);
				ActionContext.getContext().getContextMap().put("pageNo", pageNo);
				ActionContext.getContext().getContextMap().put("projectList", projectList);
				return "projectSearchSuccess";
			} else {
				return ERROR;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}

}
