package com.webapp.iamcmi.struts2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.webapp.iamcmi.hibernate.VehicalRedbook;
import com.webapp.iamcmi.listener.HibernateListener;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
 
public class VehicalRedbookAction extends ActionSupport 
	implements ModelDriven{

	VehicalRedbook vehicalRedbook = new VehicalRedbook();
	List<VehicalRedbook> vehicalRedbookList = new ArrayList<VehicalRedbook>();
	
	public String execute() throws Exception {
		return SUCCESS;
	}

	public Object getModel() {
		return vehicalRedbook;
	}
	
	public List<VehicalRedbook> getVehicalRedbookList() {
		return vehicalRedbookList;
	}

	public void setVehicalRedbookList(List<VehicalRedbook> VehicalRedbookList) {
		this.vehicalRedbookList = vehicalRedbookList;
	}

	//save customer
	public String addVehicalRedbook() throws Exception{
		
		//get hibernate session from the servlet context
		SessionFactory sessionFactory = 
	         (SessionFactory) ServletActionContext.getServletContext()
                     .getAttribute(HibernateListener.KEY_NAME);

		Session session = sessionFactory.openSession();

		//save it
	 
		session.beginTransaction();
		session.save(vehicalRedbook);
		session.getTransaction().commit();
	 
		//reload the customer list
		vehicalRedbookList = null;
		vehicalRedbookList = session.createQuery("from VehicalRedbook").list();
		
		return SUCCESS;
	
	}
	
	//list all customers
	public String listVehicalRedbook() throws Exception{
		
		//get hibernate session from the servlet context
		SessionFactory sessionFactory = 
	         (SessionFactory) ServletActionContext.getServletContext()
                     .getAttribute(HibernateListener.KEY_NAME);

		Session session = sessionFactory.openSession();

		vehicalRedbookList = session.createQuery("from VehicalRedbook").list();
		
		return SUCCESS;
	
	}	
}