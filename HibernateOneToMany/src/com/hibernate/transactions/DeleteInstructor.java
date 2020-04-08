package com.hibernate.transactions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Instructor;
import com.hibernate.entities.InstructorDetail;

public class DeleteInstructor {

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
			Instructor instr = null;
			try {
				instr = (Instructor) session.createQuery("from Instructor").getResultList().get(0);
			}
			catch(Exception e) {
				System.out.println("No data");
			}
			
			if(instr != null) {
				session.delete(instr);
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
