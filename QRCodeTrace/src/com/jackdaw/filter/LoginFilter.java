package com.jackdaw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jackdaw.entity.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String uri = request.getRequestURI();
		if(uri.contains("admin/")) {
			// 后台
			HttpSession session = request.getSession(false);
			if(session != null) {
				User user = (User) session.getAttribute("userInfo");
				if(user !=null) {
					// 已经登陆过
					if(uri.contains("Product_productInfoShow")) {
						// 产品显示页
						if(user.getRole() == 5) {
							chain.doFilter(request, response);
						} else {
							session.setAttribute("permissionMsg", "您没有该权限");
							chain.doFilter(request, response);
						}
					} else if (uri.equals("/QRCodeTrace/admin/")){
						// 后台主页
						chain.doFilter(request, response);
					} else if(uri.contains("productQRCode")) {
						// 生成二维码
						chain.doFilter(request, response);
					} else if(uri.contains("loginOut")){
						// 退出
						chain.doFilter(request, response);
					} else {
						if(user.getRole() == 1) {
							// 如果为material权限
							if(uri.contains("material") || uri.contains("Material")) {
								chain.doFilter(request, response);
							}  else {
								// 其他权限的内容  跳到没有权限提示页面
								response.sendRedirect(request.getContextPath() + "/admin/Product_productInfoShow");
								session.setAttribute("permissionMsg", "您没有该权限");
							}
						} else if(user.getRole() ==2) {
							// 如果为process权限
							if(uri.contains("process") || uri.contains("Process")) {
								chain.doFilter(request, response);
							} else {
								// 其他权限的内容  跳到没有权限提示页面
								response.sendRedirect(request.getContextPath() + "/admin/Product_productInfoShow");
								session.setAttribute("permissionMsg", "您没有该权限");
							}
						} else if (user.getRole() == 3) {
							// 如果为transport权限
							if(uri.contains("transport") || uri.contains("Transport")) {
								chain.doFilter(request, response);
							} else {
								// 其他权限的内容  跳到没有权限提示页面
								response.sendRedirect(request.getContextPath() + "/admin/Product_productInfoShow");
								session.setAttribute("permissionMsg", "您没有该权限");
							}
						} else if (user.getRole() == 4) {
							// 如果为sell权限
							if(uri.contains("sell") || uri.contains("Sell")) {
								chain.doFilter(request, response);
							} else {
								// 其他权限的内容  跳到没有权限提示页面
								response.sendRedirect(request.getContextPath() + "/admin/Product_productInfoShow");
								session.setAttribute("permissionMsg", "您没有该权限");
							}
						} else if (user.getRole() == 5) {
							// 如果为all权限
							 chain.doFilter(request, response);
						} else {
							// 其他权限的内容  跳到没有权限提示页面
							response.sendRedirect(request.getContextPath() + "/admin/Product_productInfoShow");
							session.setAttribute("permissionMsg", "您没有该权限");
						}
					}
				} else {
					// 未登录过 跳到登陆界面 userInfo==null
					response.sendRedirect(request.getContextPath() + "/#.action");
				}
			} else {
				// 未登录过 跳到登陆界面 session==null
				response.sendRedirect(request.getContextPath() + "/#.action");
			}
		} else {
			// 前台
			chain.doFilter(request, response);
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
