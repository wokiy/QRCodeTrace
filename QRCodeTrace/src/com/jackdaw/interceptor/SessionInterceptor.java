package com.jackdaw.interceptor;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jackdaw.util.HibernateUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 
 * @author Sgoldfish
 *
 */
public class SessionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4744578661460922210L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			
			String result = invocation.invoke();
			
			tx.commit();
			return result;
		} catch (Exception e) {
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return "error/error.jsp";
		}
	}
}
