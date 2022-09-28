package com.java.pojo;

import java.util.Properties;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;



public class Hibernateutil {
	
	static SessionFactory sfactory=null;
	public static SessionFactory getSessionFactory() {
		 if(sfactory==null) {
			 Configuration cfg=new Configuration();
			 Properties prop=new Properties();
			 prop.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
			 prop.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate_revision");
			 prop.put(Environment.PASS, "414141");
			 prop.put(Environment.USER, "root");
			 prop.put(Environment.HBM2DDL_AUTO, "create");
			 prop.put(Environment.SHOW_SQL,true);
			 prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			 
//			 prop.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
//			 prop.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
			 cfg.setProperties(prop);
			 cfg.addAnnotatedClass(Student.class);
			 
			ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		     sfactory=cfg.buildSessionFactory( registry);
		   
		 }
		return sfactory;
		 
	}

}
