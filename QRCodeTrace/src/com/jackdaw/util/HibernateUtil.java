package com.jackdaw.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate工具类。用于获取单例的会话工厂。
 * @author E-Kunt
 *
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private HibernateUtil() {
		
	}

    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration cfg = new Configuration().configure().setNamingStrategy(new HibernateNamingStrategy());
        	StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        	                    .applySettings(cfg.getProperties()).build();
        	SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        	return sessionFactory;
            
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
