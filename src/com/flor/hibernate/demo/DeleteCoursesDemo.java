package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.entity.Course;
import com.flor.entity.Instructor;
import com.flor.entity.InstructorDetail;




public class DeleteCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();	
	
	try {
		
		int theId = 10;
		session.beginTransaction();
		
		Instructor tempInstructor = session.get(Instructor.class, theId);
		Course tempCourse = session.get(Course.class, theId);
		
		session.delete(tempCourse);
		session.getTransaction().commit();
	
		
	}
	finally {
		session.close();
		factory.close();
		}
	}
}
