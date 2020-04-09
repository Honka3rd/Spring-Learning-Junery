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

public class GetCoursesFromStudent {

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
			
			List<Student> students = session.createQuery("from Student s where s.firstName='E'").getResultList();
			
			Student stu = null;
			for(Student s : students) {
				if(s.getCourses().size() != 0) {
					stu = s;
				}
			}
			
			if(stu != null) {
				System.out.println(stu.getFirstName());
				System.out.println(stu.getCourses());
			}
			else {
				System.out.println("no such student");
			}
			
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
