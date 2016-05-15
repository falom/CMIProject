package com.webapp.iamcmi.tester;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;

import com.webapp.iamcmi.hibernate.HibernateUtil;
import com.webapp.iamcmi.hibernate.TestTable;

public class TestHibernate {
	private static SessionFactory sessionFactory;
    
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();  
          
        TestTable testTable = new TestTable();  
        //testTable.setId(5);
        testTable.setFirst("connect hibernate");
        testTable.setLast("successfully");
        testTable.setAge(26);  
          
        session.save(testTable);  
        session.getTransaction().commit();  
          
        session.close(); 
        System.out.println("Successfully..");
	}
}