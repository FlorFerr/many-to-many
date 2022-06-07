package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.entity.Course;
import com.flor.entity.Instructor;
import com.flor.entity.InstructorDetail;
import com.flor.entity.Review;
import com.flor.entity.Student;




public class GetCoursesforAStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();	
	
	try {
		
		session.beginTransaction();
		
		int theId= 2;
		
		Student tempStudent = session.get(Student.class, theId);
				
		System.out.println("Courses: " + tempStudent.getCourses());

		session.getTransaction().commit();
	
	}
	finally {
		session.close();
		factory.close();
		}
	}
}
