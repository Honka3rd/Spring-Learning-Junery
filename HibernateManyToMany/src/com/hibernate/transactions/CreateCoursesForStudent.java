package com.hibernate.transactions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Course;
import com.hibernate.entities.Instructor;
import com.hibernate.entities.InstructorDetail;
import com.hibernate.entities.Review;
import com.hibernate.entities.Student;

public class CreateCoursesForStudent {

	private static SessionFactory factory = null;
	public static void main(String[] args) {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Course c_1 = new Course("FIT1000");
			Course c_2 = new Course("FIT1001");
			
			Student s_1 = new Student("E","L","@");
			session.save(s_1);
			
			s_1.addCourse(c_1);
			s_1.addCourse(c_2);
			
			session.save(c_1);
			session.save(c_2);
			
			// commit
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
