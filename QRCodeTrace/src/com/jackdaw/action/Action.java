package com.jackdaw.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jackdaw.entity.Company;
import com.jackdaw.entity.News;
import com.jackdaw.entity.Product;
import com.jackdaw.service.CompanyService;
import com.jackdaw.service.NewsService;
import com.jackdaw.service.ProductService;
import com.jackdaw.service.impl.CompanyServiceImpl;
import com.jackdaw.service.impl.NewsServiceImpl;
import com.jackdaw.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author Sgoldfish
 *
 */
public class Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6878353088660716199L;
	private NewsService newsService = new NewsServiceImpl();
	private CompanyService companyService = new CompanyServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	
	@Override
	public String execute() throws Exception {
		
		List<News> newsList = newsService.findAll();
		Company companyInfo = companyService.getById(1);
		
		// 随机不重复取出N个
		List<Product> List = productService.findAll();
		if(List != null && List.size() > 0) {
			List<Product> productList = List.subList(List.size() -6, List.size());
			ActionContext.getContext().getContextMap().put("productList", productList);
		}
		
		
		Collections.sort(newsList, new Comparator<News>() {
			@Override
			public int compare(News o1, News o2) {
				int num = (int)(o2.getDate().getTime() - o1.getDate().getTime());
				return num;
			}
		});
		
		ActionContext.getContext().getContextMap().put("newsList", newsList);
		ActionContext.getContext().getContextMap().put("companyInfo", companyInfo);
		
		
		return "index";
	}
}
