package com.Hibernate.SingleTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Hibernate.SingleTable.Entities.Instructor;
import com.Hibernate.SingleTable.Entities.Student;
import com.Hibernate.SingleTable.Entities.User;

public class App 
{
	private static SessionFactory factory = null;
	private static Session session = null;
    public static void main( String[] args )
    {
        factory = new Configuration()
        		.configure("hibernate.cfg.xml")
        		.addAnnotatedClass(User.class)
        		.addAnnotatedClass(Student.class)
        		.addAnnotatedClass(Instructor.class)
        		.buildSessionFactory();
        try {
        	Student stu = new Student("STU_1", "FIT0000");
        	Instructor ins = new Instructor("INS_1",10000);
        	User u = new User("U_1");
        	session = factory.getCurrentSession();
        	session.beginTransaction();
        	session.persist(u);
        	session.persist(ins);
        	session.persist(stu);
        	session.getTransaction().commit();
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
        	session.close();
        	factory.close();
        }
    }
}
