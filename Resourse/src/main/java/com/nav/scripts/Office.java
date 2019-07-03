package com.nav.scripts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Office {
	
	public static void main(String args[]){
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		
		NavEmp navEmp = new NavEmp();
		navEmp.setName("Naveen");
		navEmp.setDesignation("Manager");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(navEmp);
		transaction.commit();
	}
}