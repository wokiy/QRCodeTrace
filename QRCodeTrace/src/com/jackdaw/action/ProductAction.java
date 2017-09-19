package com.jackdaw.action;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.jackdaw.entity.Company;
import com.jackdaw.entity.Product;
import com.jackdaw.entity.Project;
import com.jackdaw.entity.User;
import com.jackdaw.exception.FileNotExsitException;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.CompanyService;
import com.jackdaw.service.ProductService;
import com.jackdaw.service.ProjectService;
import com.jackdaw.service.impl.CompanyServiceImpl;
import com.jackdaw.service.impl.ProductServiceImpl;
import com.jackdaw.service.impl.ProjectServiceImpl;
import com.jackdaw.util.FilesToZip;
import com.jackdaw.util.TracingCodeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 
 * @author Sgoldfish
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 56154108797096824L;
	private CompanyService companyService = new CompanyServiceImpl();

	// 当前页
	private int pageNo;
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	// 图片文件
	private File productImage; 
	// 图片文件名
	private String productImageFileName;
	// 图片宽高:600*400
	//'image/bmp' image/gif' 'image/jpeg' image/png' 'image/jpeg'  
	// 图片文件类型
	private String productImageContentType;
	
	// 图片标准比例 宽/高 = 4/3
	private double standardProportion = 4 * 1.0/3;
	
	// 批量的productId
	private String batchProductId;
	
	private String projectId;
	
	public String getBatchProductId() {
		return batchProductId;
	}

	public void setBatchProductId(String batchProductId) {
		this.batchProductId = batchProductId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public File getProductImage() {
		return productImage;
	}

	public String getProductImageFileName() {
		return productImageFileName;
	}

	public String getProductImageContentType() {
		return productImageContentType;
	}

	public void setProductImage(File productImage) {
		this.productImage = productImage;
	}

	public void setProductImageFileName(String productImageFileName) {
		this.productImageFileName = productImageFileName;
	}

	public void setProductImageContentType(String productImageContentType) {
		this.productImageContentType = productImageContentType;
	}

	private ProductService service = new ProductServiceImpl();
	private ProjectService projectService = new ProjectServiceImpl();
	
	private Product product = new Product();
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public Product getModel() {
		return product;
	}
	
	// 下载的文件名
	private String downFileName;
	public String getDownFileName() {
		downFileName =  "" + product.getId() +".png";
		return downFileName;
	}

	public void setDownFileName(String downFileName) {
		this.downFileName = "" + product.getId() +".png";
	}
	
	// 批量下载的文件名
	private String batchDownFileName;

	public String getBatchDownFileName() {
		try {
			batchDownFileName = URLEncoder.encode("第"+pageNo+"页批量下载"+".zip", "UTF-8");
			return batchDownFileName;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 分页方法
	 */
	private void pageFunction() {
		if(pageNo <= 0) {
			pageNo = 1;
		}
		List<Product> productList = service.findInPage(pageNo);
		int totalPage = service.getTotalPage();
		int totalRow = service.getTotalRow();
		int pageRow = service.getPageRow();
		ActionContext.getContext().getContextMap().put("pageRow", pageRow);
		// List<Product>	productList = service.findAll();
		ActionContext.getContext().getContextMap().put("totalPage", totalPage);
		ActionContext.getContext().getContextMap().put("totalRow", totalRow);
		ActionContext.getContext().getContextMap().put("pageNo", pageNo);
		ActionContext.getContext().getContextMap().put("productList", productList);
	}
	
	/**
	 * 产品信息界面
	 * @return
	 */
	public String productInfoShow() {
			try {
				User loginUser = (User) ActionContext.getContext().getSession().get("userInfo");
				HttpSession session = ServletActionContext.getRequest().getSession(false);
				if(session.getAttribute("mark") == null) {
					session.removeAttribute("permissionMsg");
				}
				if(loginUser != null) {
					if(loginUser.getRole() == 1) {
						return "loginMaterialRole";
					} else if(loginUser.getRole() == 2) {
						return "loginProcessRole";
					} else if(loginUser.getRole() == 3) {
						return "loginTransportRole";
					} else if(loginUser.getRole() == 4) {
						return "loginSellRole";
					} else if(loginUser.getRole() == 5) {
						pageFunction();
						Company companyInfo = companyService.getById(1);
						ActionContext.getContext().getContextMap().put("companyInfo", companyInfo);
						return SUCCESS;
					} else {
						return ERROR;
					}
				} else {
					pageFunction();
					Company companyInfo = companyService.getById(1);
					ActionContext.getContext().getContextMap().put("companyInfo", companyInfo);
					return SUCCESS;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		
	}
	
	/**
	 * 跳转到 产品_原料 
	 */
	public String materialInfoShow() {
		try {
			pageFunction();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 跳转到 产品_加工 
	 */
	public String processInfoShow() {
		try {
			pageFunction();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 跳转到 产品_运输 
	 */
	public String transportInfoShow() {
		try {
			pageFunction();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 跳转到 产品_销售 
	 */
	public String sellInfoShow() {
		try {
			pageFunction();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 产品信息添加界面
	 */
	public String addInput() {
		try {
			List<Project> projectList = projectService.getAll();
			ActionContext.getContext().getContextMap().put("projectList", projectList);
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 产品信息添加操作
	 */
	public String productSave() {
		try {
			TracingCodeUtil codeUtil = new TracingCodeUtil();
			Project project = projectService.getById(projectId.trim());
			product.setName(project.getName());
			String tracingCode = codeUtil.getTracingCode(project);
			if(productImage != null) {
				
				// 图片文件夹处理
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
				String date = sdf.format(new Date());
				String realPath = ServletActionContext.getServletContext().getRealPath(File.separator+"images"+File.separator+"product");
				StringBuffer savePath = new StringBuffer();
				savePath.append(realPath);
				savePath.append(File.separator).append(date);
				File file = new File(savePath.toString());
				if(!file.exists()) {
					file.mkdirs();
				}
				// 处理浏览器上传文件可能为绝对路径问题
				int index = productImageFileName.lastIndexOf(File.separator+File.separator);
				if(index != -1) {
					productImageFileName = productImageFileName.substring(index +1);
				}
				// 处理上传文件可能同名的问题
				index = productImageFileName.lastIndexOf(".");
				
				productImageFileName = tracingCode + productImageFileName.substring(index);
				
				// 上传到服务器
				File destFile = new File(savePath.toString(),productImageFileName);
				FileUtils.copyFile(productImage, destFile);
				
				// 校验图片大小
				Image image = new ImageIcon(destFile.getAbsolutePath()).getImage();
				int width = image.getWidth(null);
				int height = image.getHeight(null);
				if (width > 600 || height > 400) {
					// 删除不符合大小的图片
					destFile.delete();
					List<Project> projectList = projectService.getAll();
					ActionContext.getContext().getContextMap().put("projectList", projectList);
					ActionContext.getContext().getSession().put("msg", "您上传的图片大小大于600*400");
					return INPUT;
				}
				
				// 当前图片比例
				double proportion = width*1.0/height;
				int standardWidth = 400;
				int standardHeight = 300; 
				// 校验图片比例
				if(proportion != standardProportion) {
					destFile.delete();
					 if ( width >= height)  
			            {  
						 standardHeight = (int)Math.round((height * standardWidth * 1.0 / width));  
			            }  
			            else   
			            {  
			            	standardWidth = (int)Math.round((width * standardHeight * 1.0 / height));  
			            }  
				
					BufferedImage bi = new BufferedImage(standardWidth, standardHeight, BufferedImage.TYPE_INT_RGB);
					Graphics2D graphics = (Graphics2D) bi.getGraphics();
					graphics.drawImage(image, 0, 0, null);
					ImageIO.write(bi, "JPEG", destFile);
				}
				// 符合要求的图片
				product.setPic("images/"+"product/"+date+"/"+ productImageFileName);
			}
			service.add(project, product);
			return SUCCESS;
		} catch(ServiceException e) {
			ActionContext.getContext().getSession().put("msg", e.getMessage());
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} 
	}
	
	/**
	 * 产品信息修改界面
	 */
	public String updateInput() {
		try {
			Product productInfo = service.getById(product.getId());
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.push(productInfo);
			ActionContext.getContext().getContextMap().put("productInfo", productInfo);
			List<Project> projectList = projectService.getAll();
			ActionContext.getContext().getContextMap().put("projectList", projectList);
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 产品信息修改操作
	 * @return
	 */
	public String productUpdate() {
		try {
			if(product != null){
				//处理头像
				if(productImage != null){
					
					// 图片文件夹处理
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
					String date = sdf.format(new Date());
					// D:\Develop\Project\QRCode\projectWorkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\QRCodeTrace\images\product
					String realPath = ServletActionContext.getServletContext().getRealPath(File.separator+"images"+File.separator+"product");
					StringBuffer savePath = new StringBuffer();
					savePath.append(realPath);
					savePath.append(File.separator).append(date);
					File file = new File(savePath.toString());
					if(!file.exists()) {
						file.mkdirs();
					}
					// 处理浏览器上传文件可能为绝对路径问题
					int index = productImageFileName.lastIndexOf(File.separator+File.separator);
					if(index != -1) {
						productImageFileName = productImageFileName.substring(index +1);
					}
					// 处理上传文件可能同名的问题
					index = productImageFileName.lastIndexOf(".");
					
					productImageFileName = product.getId() + productImageFileName.substring(index);
					
					// 上传到服务器
					File destFile = new File(savePath.toString(),productImageFileName);
					// 删除原来的文件
					destFile.delete();
					FileUtils.copyFile(productImage, destFile,true);
					
					// 校验图片大小
					Image image = new ImageIcon(destFile.getAbsolutePath()).getImage();
					int width = image.getWidth(null);
					int height = image.getHeight(null);
					if (width > 600 || height > 400) {
						// 删除不符合大小的图片
						destFile.delete();
						List<Project> projectList = projectService.getAll();
						ActionContext.getContext().getContextMap().put("projectList", projectList);
						ActionContext.getContext().getSession().put("msg", "您上传的图片大小大于600*400");
						return INPUT;
					}
					// 当前图片比例
					double proportion = width*1.0/height;
					int standardWidth = 400;
					int standardHeight = 300; 
					// 校验图片比例
					if(proportion != standardProportion) {
						destFile.delete();
						 if ( width >= height)  
				            {  
							 standardHeight = (int)Math.round((height * standardWidth * 1.0 / width));  
				            }  
				            else   
				            {  
				            	standardWidth = (int)Math.round((width * standardHeight * 1.0 / height));  
				            } 
						BufferedImage bi = new BufferedImage(standardWidth, standardHeight, BufferedImage.TYPE_INT_RGB);
						Graphics2D graphics = (Graphics2D) bi.getGraphics();
						graphics.drawImage(image, 0, 0,standardWidth, standardHeight, null);
						graphics.dispose();
						ImageIO.write(bi, "JPEG", destFile);
					}
					// 符合要求的图片
					product.setPic("images/"+"product/"+date+"/"+ productImageFileName);
					service.update(product);
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} 
	}
	
	/**
	 * 产品信息删除操作
	 * @return
	 */
	public String productDelete() {
		try {
			Product deleteProduct = service.getById(product.getId());
			service.delete(deleteProduct);
			String destPath = ServletActionContext.getServletContext().getRealPath(File.separator+deleteProduct.getPic());
			File destFile = new File(destPath);
			destFile.delete();
			return "productSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 根据产品或产品追溯码查找相应的产品
	 */
	private void search() {
		String name = product.getName();
		List<Product> productList = service.getByName(name.trim());
		if(productList == null || productList.size() <=0) {
			Product product = service.getById(name.trim());
			productList.add(product);
		}
		int totalRow = productList.size();
		int pageRow = service.getPageRow();
		int totalPage = productList.size() / pageRow;
		ActionContext.getContext().getContextMap().put("pageRow", pageRow);
		ActionContext.getContext().getContextMap().put("totalPage", totalPage);
		ActionContext.getContext().getContextMap().put("totalRow", totalRow);
		ActionContext.getContext().getContextMap().put("pageNo", pageNo);
		ActionContext.getContext().getContextMap().put("productList", productList);
	}
	
	/**
	 * 根据产品或产品追溯码查找相应的产品  跳转到产品信息界面
	 * @return
	 */
	public String productSearch() {
		try {
			if(product !=null) {
				search();
				return "productSearchSuccess";
			} else {
				return ERROR;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 根据产品或产品追溯码查找相应的产品  跳转到产品_原料信息界面
	 * @return
	 */
	public String materialProductSearch() {
		try {
			if(product !=null) {
				search();
				return "materialSearchSuccess";
			} else {
				return ERROR;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 根据产品或产品追溯码查找相应的产品  跳转到产品_加工信息界面
	 * @return
	 */
	public String processProductSearch() {
		try {
			if(product !=null) {
				search();
				return "processSearchSuccess";
			} else {
				return ERROR;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 根据产品或产品追溯码查找相应的产品  跳转到产品_运输信息界面
	 * @return
	 */
	public String transportProductSearch() {
		try {
			if(product !=null) {
				search();
				return "transportSearchSuccess";
			} else {
				return ERROR;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 根据产品或产品追溯码查找相应的产品  跳转到产品_销售信息界面
	 * @return
	 */
	public String sellProductSearch() {
		try {
			if(product !=null) {
				search();
				return "sellSearchSuccess";
			} else {
				return ERROR;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 生成二维码图片
	 * @return
	 */
	public String productQRCode() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			service.createQRCode(request, product.getId().trim(),File.separator+"QRCodes");
			request.setAttribute("productId", product.getId().trim());
			return "productQRCodeSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 下载二维码图片
	 */
	public String productQRCodeDownload() {
		try {
			return "productQRCodeDownload";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	// 要返回给浏览器的流
	public InputStream getAttrInputStream() {
		String id = product.getId();
		InputStream in = ServletActionContext.getServletContext().getResourceAsStream(File.separator+"QRCodes"+File.separator + id +".png");
		/**
		 * java.lang.IllegalArgumentException:Can not find a java.io.InputStream with the
		 *  name [attrInputStream] in the invocation stack. Check the <param name="inputName"> tag
		 * specified for this action
		 * 这个异常是InputStream 为null;
		 */
		return in;
	}
	
	/**
	 * 批量下载文件
	 */
	public String productQRCodeBatchDownload() {
		try {
			return "productQRCodeBatchDownload";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public InputStream getBatchInputStream() throws FileNotExsitException {
		InputStream in = null;
		try {
				HttpServletRequest request = ServletActionContext.getRequest();
				File sourceFile = new File(request.getServletContext().getRealPath(File.separator+"QRCodesTemp"));
				
				String[] productIds = batchProductId.split(",");
				for (String productId : productIds) {
					service.createQRCode(request, productId.trim(),File.separator+"QRCodesTemp");
				}
				
				File destFile = new File(request.getServletContext().getRealPath(File.separator+"zips"+File.separator+"第"+pageNo+"页批量打印"+".zip"));
				FilesToZip.fileToZip(sourceFile, destFile);
				in = new FileInputStream(destFile);
				File[] listFiles = sourceFile.listFiles();
				
				if(listFiles !=null && listFiles.length > 0) {
					for (File file : listFiles) {
						System.out.println(file.delete());
					}
				}
				return in;
		} catch (Exception e) {
			e.printStackTrace();
			return in;
		} 
	}
	
	
	/**
	 * 扫描二维码后返回的产品信息
	 */
	public String qrCodeProductInfoShow() {
		try {
			if(product!=null) {
				Product productInfo = service.getById(product.getId().trim());
				Company companyInfo = companyService.getById(1);
				
				if(productInfo != null && companyInfo != null) {
					ActionContext.getContext().getContextMap().put("productInfo", productInfo);
					ActionContext.getContext().getContextMap().put("companyInfo", companyInfo);
					return SUCCESS;
				} else {
					ActionContext.getContext().getSession().put("msg", "找不到该产品,请检查产品追溯码");
					return "productNotFound";
				}
				
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
