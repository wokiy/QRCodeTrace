package com.jackdaw.action;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.jackdaw.entity.Company;
import com.jackdaw.service.CompanyService;
import com.jackdaw.service.impl.CompanyServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author Sgoldfish
 *
 */
public class CompanyAction extends ActionSupport implements ModelDriven<Company> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -239963247150572383L;
	private CompanyService service = new CompanyServiceImpl();
	private Company company = new Company();
	
	private String sourcefile;
	// 上传的图片
	private File frontendImage;

	private String frontendImageFileName;
	
	private String frontendImageContentType;
	
	public File getFrontendImage() {
		return frontendImage;
	}

	public void setFrontendImage(File frontendImage) {
		this.frontendImage = frontendImage;
	}
	public String getFrontendImageFileName() {
		return frontendImageFileName;
	}

	public String getFrontendImageContentType() {
		return frontendImageContentType;
	}

	public void setFrontendImageFileName(String frontendImageFileName) {
		this.frontendImageFileName = frontendImageFileName;
	}

	public void setFrontendImageContentType(String frontendImageContentType) {
		this.frontendImageContentType = frontendImageContentType;
	}

	public String getSourcefile() {
		return sourcefile;
	}

	public void setSourcefile(String sourcefile) {
		this.sourcefile = sourcefile;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public Company getModel() {
		return company;
	}
	
	public String updateInput() {
		try {
			Company companyInfo = service.getById(1);
			ActionContext.getContext().getValueStack().push(companyInfo);
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String companyUpdate() {
		try {
			service.update(company);
			return "companySuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String  companyAbout() {
		try {
			Company companyInfo = service.getById(1);
			ActionContext.getContext().getContextMap().put("companyInfo", companyInfo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String frontendInfoShow() {
		try {
			Company companyInfo = service.getById(1);
			ActionContext.getContext().getContextMap().put("companyInfo", companyInfo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String imgChange() {
		try {
			String realPath = ServletActionContext.getServletContext().getRealPath(File.separator+"images");
			int index = frontendImageFileName.lastIndexOf(File.separator+File.separator);
			if(index != -1) {
				frontendImageFileName = frontendImageFileName.substring(index +1);
			}
			
			index = frontendImageFileName.lastIndexOf(".");
			frontendImageFileName = sourcefile + frontendImageFileName.substring(index);
			
			File destFile = new File(realPath,frontendImageFileName);
			// 删除原来的文件
			if(destFile.exists()) {
				destFile.delete();
			}
			FileUtils.copyFile(frontendImage, destFile);
			Company companyInfo = service.getById(1);
			if("mainpic".equals(sourcefile)) {
				companyInfo.setMainPic("images/"+ frontendImageFileName);
			} else if("pix1".equals(sourcefile)) {
				companyInfo.setEnviromentPic1("images/"+ frontendImageFileName);
			} else if("pix2".equals(sourcefile)) {
				companyInfo.setEnviromentPic2("images/"+ frontendImageFileName);
			} else if("pix3".equals(sourcefile)) {
				companyInfo.setEnviromentPic3("images/"+ frontendImageFileName);
			} else if("pix4".equals(sourcefile)) {
				companyInfo.setEnviromentPic4("images/"+ frontendImageFileName);
			} else if("pix5".equals(sourcefile)) {
				companyInfo.setEnviromentPic5("images/"+ frontendImageFileName);
			} else if("pix6".equals(sourcefile)) {
				companyInfo.setEnviromentPic6("images/"+ frontendImageFileName);
			} else if("pix7".equals(sourcefile)) {
				companyInfo.setEnviromentPic7("images/"+ frontendImageFileName);
			} else if("pix8".equals(sourcefile)) {
				companyInfo.setEnviromentPic8("images/"+ frontendImageFileName);
			} else {
				return ERROR;
			}
			service.update(companyInfo);
			return "imgChangeSUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
