package com.jackdaw.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.jackdaw.entity.Company;
import com.jackdaw.entity.News;
import com.jackdaw.service.CompanyService;
import com.jackdaw.service.NewsService;
import com.jackdaw.service.impl.CompanyServiceImpl;
import com.jackdaw.service.impl.NewsServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author Sgoldfish
 *
 */
public class NewsAction extends ActionSupport implements ModelDriven<News>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8505565615612328521L;
	
	// 当前页
	private int pageNo;
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	private News news = new News();
	private NewsService service = new NewsServiceImpl();
	private CompanyService companyService = new CompanyServiceImpl();

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public News getModel() {
		return news;
	}
	
	public String newsInfoShow() {
		try {
			if(pageNo <= 0) {
				pageNo = 1;
			}
			List<News> newsList = service.findInPage(pageNo);
			Company companyInfo = companyService.getById(1);
			int totalPage = service.getTotalPage();
			int totalRow = service.getTotalRow();
			int pageRow = service.getPageRow();
			ActionContext.getContext().getContextMap().put("pageRow", pageRow);
			ActionContext.getContext().getContextMap().put("totalPage", totalPage);
			ActionContext.getContext().getContextMap().put("totalRow", totalRow);
			ActionContext.getContext().getContextMap().put("pageNo", pageNo);
			// List<News> newsList = service.findAll();
			
			Collections.sort(newsList, new Comparator<News>() {
				@Override
				public int compare(News o1, News o2) {
					int num = (int)(o2.getDate().getTime() - o1.getDate().getTime());
					return num;
				}
			});
			ActionContext.getContext().getContextMap().put("newsList", newsList);
			ActionContext.getContext().getContextMap().put("companyInfo", companyInfo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String addInput() {
		return INPUT;
	}
	
	public String newsSave() {
		try {
			news.setDate(new Date());
			service.add(news);
			return "newsSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String updateInput() {
		try {
			News updateNews = service.getById(news.getId());
			ActionContext.getContext().getValueStack().push(updateNews);
			return INPUT;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String newsUpdate() {
		try {
			news.setDate(new Date());
			service.update(news);
			return "newsSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String newsDelete() {
		try {
			service.delete(news);
			return "newsSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String newsDetail() {
		try {
			News newsInfo = service.getById(news.getId());
			Company companyInfo = companyService.getById(1);
			News preNews = service.getPreNews(newsInfo.getDate());
			News nextNews = service.getNextNews(newsInfo.getDate());
			
			ActionContext.getContext().getContextMap().put("newsInfo", newsInfo);
			ActionContext.getContext().getContextMap().put("companyInfo", companyInfo);
			ActionContext.getContext().getContextMap().put("preNews", preNews);
			ActionContext.getContext().getContextMap().put("nextNews", nextNews);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
