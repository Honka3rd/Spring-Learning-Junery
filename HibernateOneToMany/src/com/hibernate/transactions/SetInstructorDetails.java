package com.hibernate.transactions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Instructor;
import com.hibernate.entities.InstructorDetail;

public class SetInstructorDetails {

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
			InstructorDetail detail = new InstructorDetail("long face media", "pounch out white pig");
			Instructor instr = new Instructor("M","M","@333");
			instr.setDetail(detail);
			
			// instructor's cascade type is all, therefore set the associated detail object
			session.save(instr);
			
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
