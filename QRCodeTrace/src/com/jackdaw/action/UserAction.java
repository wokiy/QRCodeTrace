package com.jackdaw.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.jackdaw.entity.User;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.UserService;
import com.jackdaw.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 
 * @author Sgoldfish
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6546419015211214228L;
	// 当前页
	private int pageNo;
	
	private File licensePicImage;
	private String licensePicImageFileName;
	private String licensePicImageContentType;
	
	public File getLicensePicImage() {
		return licensePicImage;
	}

	public String getLicensePicImageFileName() {
		return licensePicImageFileName;
	}

	public String getLicensePicImageContentType() {
		return licensePicImageContentType;
	}

	public void setLicensePicImage(File licensePicImage) {
		this.licensePicImage = licensePicImage;
	}

	public void setLicensePicImageFileName(String licensePicImageFileName) {
		this.licensePicImageFileName = licensePicImageFileName;
	}

	public void setLicensePicImageContentType(String licensePicImageContentType) {
		this.licensePicImageContentType = licensePicImageContentType;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	private User user = new User();
	private UserService service = new UserServiceImpl();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	/**
	 * 跳转到用户管理首页
	 */
	public String userInfoShow() {
		try {
			// List<User> userList = service.findAll();
			if(pageNo <= 0) {
				pageNo = 1;
			}
			List<User> userList = service.findInPage(pageNo);
			int totalPage = service.getTotalPage();
			int totalRow = service.getTotalRow();
			int pageRow = service.getPageRow();
			// List<Product>	productList = service.findAll();
			ActionContext.getContext().getContextMap().put("pageRow", pageRow);
			ActionContext.getContext().getContextMap().put("totalPage", totalPage);
			ActionContext.getContext().getContextMap().put("totalRow", totalRow);
			ActionContext.getContext().getContextMap().put("pageNo", pageNo);
			// ActionContext.getContext().getSession().put("productList", productList);
			ActionContext.getContext().getContextMap().put("userList", userList);
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
			User userInfo = service.getByUserName(user.getUserName());
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.push(userInfo);
			ActionContext.getContext().getContextMap().put("userInfo", userInfo);
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
	public String userSave() {
		try {
			// 图片文件夹处理
			if(licensePicImage != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
				String date = sdf.format(new Date());
				String realPath = ServletActionContext.getServletContext().getRealPath(File.separator+"images"+File.separator+"license");
				StringBuffer savePath = new StringBuffer();
				savePath.append(realPath);
				savePath.append(File.separator).append(date);
				File file = new File(savePath.toString());
				if(!file.exists()) {
					file.mkdirs();
				}
				// 处理浏览器上传文件可能为绝对路径问题
				int index = licensePicImageFileName.lastIndexOf(File.separator+File.separator);
				if(index != -1) {
					licensePicImageFileName = licensePicImageFileName.substring(index +1);
				}
				// 处理上传文件可能同名的问题
				index = licensePicImageFileName.lastIndexOf(".");
				
				licensePicImageFileName = user.getLicenseNumber() + licensePicImageFileName.substring(index);
				
				// 上传到服务器
				File destFile = new File(savePath.toString(),licensePicImageFileName);
				FileUtils.copyFile(licensePicImage, destFile);
				user.setLicensePic("images"+"/"+"license/"+date+"/"+ licensePicImageFileName);
			}
			service.add(user);
			return "userSuccess";
		} catch (ServiceException e) {
			ActionContext.getContext().getContextMap().put("msg", e.getMessage());
			return "userAddFail";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	/**
	 * 修改方法(点击修改后)
	 */
	public String userUpdate() {
		try {
			// 图片文件夹处理
			if(licensePicImage != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
				String date = sdf.format(new Date());
				String realPath = ServletActionContext.getServletContext().getRealPath(File.separator+"images"+File.separator+"license");
				StringBuffer savePath = new StringBuffer();
				savePath.append(realPath);
				savePath.append(File.separator).append(date);
				File file = new File(savePath.toString());
				if(!file.exists()) {
					file.mkdirs();
				}
				// 处理浏览器上传文件可能为绝对路径问题
				int index = licensePicImageFileName.lastIndexOf(File.separator+File.separator);
				if(index != -1) {
					licensePicImageFileName = licensePicImageFileName.substring(index +1);
				}
				// 处理上传文件可能同名的问题
				index = licensePicImageFileName.lastIndexOf(".");
				
				licensePicImageFileName = user.getLicenseNumber() + licensePicImageFileName.substring(index);
				
				// 上传到服务器
				File destFile = new File(savePath.toString(),licensePicImageFileName);
				FileUtils.copyFile(licensePicImage, destFile);
				user.setLicensePic("images"+"/"+"license/"+date+"/"+ licensePicImageFileName);
			}
			
			service.update(user);
			return "userSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 删除
	 */
	public String userDelete() {
		try {
			User deleteUser = service.getByUserName(user.getUserName());
			service.delete(deleteUser);
			return "userSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	/**
	 * 根据用户名搜索
	 */
	public String userSearch() {
		try {
			List<User> userList = service.getByRealName(user.getRealName());
			ActionContext.getContext().getContextMap().put("userList", userList);
			return "userSearchResult";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 用户登陆
	 */
	public String userLogin() {
		try {
			User loginUser = service.login(user);
			if(loginUser != null) {
				ActionContext.getContext().getSession().put("userInfo", loginUser);
				return "loginSuccess";
			} else {
				ActionContext.getContext().getSession().put("loginMsg", "用户名、密码或角色错误");
				return "loginFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 用户退出
	 */
	public String loginOut() {
		try {
			ServletActionContext.getRequest().getSession().removeAttribute("userInfo");
			ServletActionContext.getRequest().getSession().removeAttribute("mark");
			return "loginOutSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
