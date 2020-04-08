package com.hibernate.transactions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Course;
import com.hibernate.entities.Instructor;
import com.hibernate.entities.InstructorDetail;
import com.hibernate.entities.Review;

public class AddReviewToCourse {

	private static SessionFactory factory = null;
	public static void main(String[] args) {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Review r_1 = new Review("nice");
			Review r_2 = new Review("good");
			
			Course c = (Course) session.createQuery("from Course").getResultList().get(0);
			c.addReview(r_1);
			c.addReview(r_2);
			
			session.save(r_1);
			session.save(r_2);
			
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
