package org.cdac.pgdac.projects.pickpark.services;

import java.math.BigInteger;

import org.cdac.pgdac.projects.pickpark.model.Customer;
import org.cdac.pgdac.projects.pickpark.model.Floor;
import org.cdac.pgdac.projects.pickpark.model.Node;
import org.cdac.pgdac.projects.pickpark.model.ParkingLoc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RegisterCustomer {
public static void main(String[] args) {
		Customer  customer= new Customer("bilekahali", new BigInteger("8800233245"), "vikas", "yadav", "jeso55699");	
new RegisterCustomer().register(customer);
}
	boolean register(Customer customer){
		SessionFactory factory = new Configuration()
		.configure("hibernate.cfg.xml")
		.addAnnotatedClass(Customer.class)
		.addAnnotatedClass(ParkingLoc.class)
		.addAnnotatedClass(Floor.class)
		.addAnnotatedClass(Node.class)
		.buildSessionFactory();
		Session session = factory.getCurrentSession();
	  try
	  {  session.beginTransaction();
	    session.save(customer);	
	    session.getTransaction().commit();
	  }
	  catch(Exception e){
		  session.getTransaction().rollback();
		  e.printStackTrace();
		  return false;
	  }
	    finally{
	factory.close();
}
	  return true;
	}
	
}
