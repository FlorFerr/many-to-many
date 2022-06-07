package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.entity.Course;
import com.flor.entity.Instructor;
import com.flor.entity.InstructorDetail;




public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();	
	
	try {
		
		int theId = 2;
		session.beginTransaction();
		
		Instructor tempInstructor = session.get(Instructor.class, theId);
		
		Course tempCourse1 = new Course("The air guitar");
		Course tempCourse2 = new Course("The paintball masterclass");
		
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		
		session.save(tempCourse1);
		session.save(tempCourse2);
		
		

		
		
		session.getTransaction().commit();
	
		
	}
	finally {
		session.close();
		factory.close();
		}
	}
}
