package com.hibernate.transactions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Course;
import com.hibernate.entities.Instructor;
import com.hibernate.entities.InstructorDetail;
import com.hibernate.entities.Review;
import com.hibernate.entities.Student;

public class CreateCourseAndStudent {

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
			
			//create course
			Course c_1 = new Course("go happy");
			session.save(c_1);
			
			// create students
			Student stu_1 = new Student("AAA", "BBB", "233@.com");
			Student stu_2 = new Student("CCC", "DDD", "wdnmd@.com");
			
			// add students to course
			c_1.addStudent(stu_1);
			c_1.addStudent(stu_2);
			
			// save students
			session.save(stu_1);
			session.save(stu_2);
			
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
