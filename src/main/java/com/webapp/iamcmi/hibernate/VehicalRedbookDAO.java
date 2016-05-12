package com.webapp.iamcmi.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class VehicalRedbookDAO {
	   Session session;

	   Transaction transaction;

	   @SuppressWarnings("unchecked")
	   public List<VehicalRedbook> getVehicalRedbook()
	   {
	      List<VehicalRedbook> students = new ArrayList<VehicalRedbook>();
	      try
	      {
	         students = session.createQuery("from VehicalRedbook").list();
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      return students;
	   }

	   public void addVehicalRedbook(VehicalRedbook vehicalRedbook)
	   {
	      session.save(vehicalRedbook);
	   }
}
