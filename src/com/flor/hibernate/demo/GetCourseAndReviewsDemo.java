package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.entity.Course;
import com.flor.entity.Instructor;
import com.flor.entity.InstructorDetail;
import com.flor.entity.Review;




public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();	
	
	try {
		int theId=10;
		session.beginTransaction();
		
		Course tempCourse = session.get(Course.class, theId);
		
		System.out.println("The course: " + tempCourse);
		System.out.println("The reviews: " + tempCourse.getReviews());
		

		session.getTransaction().commit();
	
	}
	finally {
		session.close();
		factory.close();
		}
	}
}
