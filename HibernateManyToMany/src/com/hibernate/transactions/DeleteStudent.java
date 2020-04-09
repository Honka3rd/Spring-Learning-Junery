package com.hibernate.transactions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Course;
import com.hibernate.entities.Instructor;
import com.hibernate.entities.InstructorDetail;
import com.hibernate.entities.Review;
import com.hibernate.entities.Student;

public class DeleteStudent {
	private static SessionFactory factory = null;

	public static void main(String[] args) {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Review.class).buildSessionFactory();
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("before");
			System.out.println(session.createQuery("from Student").getResultList());
			Student s = null;
			s = (Student) session.createQuery("from Student s where s.firstName='AAA'").getResultList().get(0);
			if (s != null) {
				session.delete(s);
			}
			// commit
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("after");
			System.out.println(session.createQuery("from Student").getResultList());
			// commit
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

			if (factory != null) {
				factory.close();
			}
		}
	}
}
