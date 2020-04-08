package com.hibernate.transactions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Course;
import com.hibernate.entities.Instructor;
import com.hibernate.entities.InstructorDetail;

public class AddInstructorWithCourses {

	private static SessionFactory factory = null;
	public static void main(String[] args) {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			Course c_1 = new Course("A_1");
			Course c_2 = new Course("A_2");
			
			Instructor instr = (Instructor) session.createQuery("from Instructor").getResultList().get(0);
			
			instr.addCourse(c_1);
			instr.addCourse(c_2);
			
			// save the object with joinColumn do not save that of mapped by
			session.save(c_1);
			session.save(c_2);
			
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
