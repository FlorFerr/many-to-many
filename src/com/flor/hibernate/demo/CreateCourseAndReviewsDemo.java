package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.entity.Course;
import com.flor.entity.Instructor;
import com.flor.entity.InstructorDetail;
import com.flor.entity.Review;




public class CreateCourseAndReviewsDemo {

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
		
		session.beginTransaction();
		
		Course tempCourse = new Course("Pacman II");
				
		tempCourse.addReviews(new Review("Horrible"));
		tempCourse.addReviews(new Review("Hermoso"));
		
		session.save(tempCourse);

		session.getTransaction().commit();
	
	}
	finally {
		session.close();
		factory.close();
		}
	}
}
