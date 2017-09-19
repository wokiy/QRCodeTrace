package com.jackdaw.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;

import com.google.zxing.WriterException;
import com.jackdaw.dao.ProductDao;
import com.jackdaw.dao.impl.ProductDaoImpl;
import com.jackdaw.entity.Material;
import com.jackdaw.entity.Process;
import com.jackdaw.entity.Product;
import com.jackdaw.entity.Project;
import com.jackdaw.entity.Sell;
import com.jackdaw.entity.Transport;
import com.jackdaw.exception.ServiceException;
import com.jackdaw.service.ProductService;
import com.jackdaw.util.QRCodeUtil;
import com.jackdaw.util.TracingCodeUtil;

/**
 * 业务逻辑层。处理和产品相关的业务。
 * @author E-Kunt
 *
 */
public class ProductServiceImpl extends ServiceSupportImpl implements ProductService {

	/**
	 * 用于记录日志文件
	 */
	private static final Logger LOG = Logger.getLogger(ProductServiceImpl.class);
	/**
	 * 产品数据访问对象
	 */
	private ProductDao productDao = new ProductDaoImpl();
	/**
	 * 分页显示时，每页多少条记录
	 */
	private final int PAGE_ROW = 9;

	@Override
	public Product loadById(String id) throws RuntimeException {
		Product product = null;
		LOG.info("尝试通过ID加载一条产品信息。");
		product = productDao.loadById(id);
		return product;
	}

	@Override
	public Product getById(String id) throws RuntimeException {
		Product product = null;
		LOG.info("尝试通过ID获得一条产品信息。");
		product = productDao.getById(id);
		return product;
	}
	
	@Override
	public Product get(Product product) throws RuntimeException {
		return getById(product.getId());
	}

	@Override
	public List<Product> getByName(String name) throws RuntimeException {
		List<Product> products = null;
		LOG.info("尝试通过名字获得一条产品信息。");
		products = productDao.getByName(name);
		return products;
	}

	@Override
	public List<Product> findAll() throws RuntimeException {
		List<Product> products = null;
		LOG.info("尝试获得所有产品信息。");
		products = productDao.findAll();
		return products;
	}

	@Override
	public List<String> findAllPic() throws RuntimeException {
		List<String> pics = null;
		LOG.info("尝试获得所有产品图片。");
		pics = productDao.findAllPic();
		return pics;
	}

	@Override
	public List<Product> findInPage(int pageNo) throws RuntimeException {
		List<Product> products = null;
		LOG.info("尝试获得第"+ pageNo +"页所有的产品信息。");
		// 产品表记录的总数量
		int totalRows = (int) productDao.count();
		// 显示所有产品一共需要多少页
		int totalPages = (totalRows + PAGE_ROW - 1) / PAGE_ROW;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > totalPages) {
			pageNo = totalPages;
		}
		products = productDao.findLimit((pageNo - 1) * PAGE_ROW, PAGE_ROW);
		return products;
	}

	@Override
	public void add(Project project, Product product) throws RuntimeException {
		LOG.info("尝试添加一条产品信息。");
		product.setId(new TracingCodeUtil().getTracingCode(project));
		if (productDao.getById(product.getId()) != null) {
			LOG.error("添加产品失败，该产品已存在。");
			throw new ServiceException("添加产品失败，该产品已存在。");
		}
		productDao.add(product);
	}

	@Override
	public void update(Product product) throws RuntimeException {
		LOG.info("尝试更新一条产品信息。");
		if (productDao.getById(product.getId()) == null) {
			LOG.error("更新产品失败，该产品不存在。");
			throw new ServiceException("更新产品失败，该产品不存在。");
		}
		productDao.clearSession();
		productDao.update(product);
	}

	@Override
	public void updateBase(Product product) throws RuntimeException {
		LOG.info("尝试更新一条产品信息。");
		if (productDao.getById(product.getId()) == null) {
			LOG.error("更新产品失败，该产品不存在。");
			throw new ServiceException("更新产品失败，该产品不存在。");
		}
		productDao.clearSession();
		productDao.updateBase(product);
	}

	@Override
	public void updateMaterial(Product product, Material material) throws RuntimeException {
		LOG.info("尝试更新一条产品原料信息。");
		product = productDao.loadById(product.getId());
		if (product == null) {
			LOG.error("更新产品原料信息失败，该产品不存在。");
			throw new ServiceException("更新产品原料信息失败，该产品不存在。");
		}
		product.setMaterial(material);
		productDao.update(product);

	}

	@Override
	public void updateProcess(Product product, Process process) throws RuntimeException {
		LOG.info("尝试更新一条产品加工信息。");
		product = productDao.loadById(product.getId());
		if (product == null) {
			LOG.error("更新产品加工信息失败，该产品不存在。");
			throw new ServiceException("更新产品加工信息失败，该产品不存在。");
		}
		product.setProcess(process);
		productDao.update(product);

	}

	@Override
	public void updateTransport(Product product, Transport transport) throws RuntimeException {
		LOG.info("尝试更新产品运输信息");
		product = productDao.loadById(product.getId());
		if (product == null) {
			LOG.error("更新产品运输信息失败，该产品不存在。");
			throw new ServiceException("更新产品运输信息失败，该产品不存在。");
		}
		product.setTransport(transport);
		productDao.update(product);

	}

	@Override
	public void updateSell(Product product, Sell sell) throws RuntimeException {
		LOG.info("尝试更新产品销售信息。");
		product = productDao.loadById(product.getId());
		if (product == null) {
			LOG.error("更新产品销售信息失败，该产品不存在。");
			throw new ServiceException("更新产品销售信息失败，该产品不存在。");
		}
		product.setSell(sell);
		productDao.update(product);
	}

	@Override
	public void delete(Product product) throws RuntimeException {
		LOG.info("尝试删除产品一条运输信息。");
		productDao.delete(product);

	}

	@Override
	public void deleteAll() throws RuntimeException {
		LOG.info("尝试删除产品所有运输信息。");
		productDao.deleteAll();
	}

	@Override
	public long count() throws RuntimeException {
		long count = 0;
		LOG.info("尝试获得所有产品的数量。");
		count = productDao.count();
		return count;
	}

	@Override
	public int getTotalRow() throws RuntimeException {
		return (int) productDao.count();
	}

	@Override
	public int getTotalPage() throws RuntimeException {
		return (getTotalRow() + getPageRow() - 1) / getPageRow();
	}

	@Override
	public int getPageRow() throws RuntimeException {
		return PAGE_ROW;
	}

	@Override
	public void sqlDml(String sql) throws RuntimeException {
		sqlDml(sql, productDao);
	}

	@Override
	public List<Object[]> sqlDql(String sql) throws RuntimeException {
		return sqlDql(sql, productDao);
	}
	
	@Override
	public void createQRCode(ServletRequest request, String productId,String dir) throws RuntimeException {
		try {
			LOG.info("尝试创建产品二维码图片文件。");
			String content = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
							+ request.getServletContext().getContextPath()+ "/"
							+ "Product_qrCodeProductInfoShow?id=" + productId; // 改成这样
			String filePath = request.getServletContext().getRealPath(dir);
			String fileName = productId + ".png";
			QRCodeUtil.encode(content,filePath,fileName);
		} catch (WriterException e) {
			LOG.error("创建产品二维码图片文件失败，读写文件发生异常(WriterException)。");
			throw new ServiceException("创建产品二维码图片文件失败，读写文件发生异常(WriterException)。",e);
		} catch (IOException e) {
			LOG.error("创建产品二维码图片文件失败，读写文件发生异常(IOException)。");
			throw new ServiceException("创建产品二维码图片文件失败，读写文件发生异常(IOException)。",e);
		}
		LOG.info("创建产品二维码图片文件成功。");
	}
}
