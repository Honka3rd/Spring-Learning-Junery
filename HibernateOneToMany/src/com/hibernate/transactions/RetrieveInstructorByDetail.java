package com.hibernate.transactions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Instructor;
import com.hibernate.entities.InstructorDetail;

public class RetrieveInstructorByDetail {

	private static SessionFactory factory = null;
	public static void main(String[] args) {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = null;
		
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			InstructorDetail detail = null;
			try {
				detail = (InstructorDetail) session.createQuery("from InstructorDetail").getResultList().get(0);
			}
			catch(Exception e) {
				System.out.println("No data");
			}
			if(detail != null) {
				System.out.println(detail.getInstructor().getFirstName());
				System.out.println(detail.getInstructor().getLastName());
				System.out.println(detail.getInstructor().getEmail());
			}
			
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
			
			if(factory != null) {
				factory.close();
			}
		}

	}

}
