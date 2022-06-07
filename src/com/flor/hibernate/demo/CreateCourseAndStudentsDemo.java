package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.entity.Course;
import com.flor.entity.Instructor;
import com.flor.entity.InstructorDetail;
import com.flor.entity.Review;
import com.flor.entity.Student;




public class CreateCourseAndStudentsDemo {

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
		
		int theId = 2;
		
		session.beginTransaction();
		
		Student tempStudent = session.get(Student.class, theId);
		
		Course tempCourse1 = new Course("Rubik's cube");
		Course tempCourse2 = new Course("Atario 2600");
				
		tempCourse1.addStudent(tempStudent);
		tempCourse2.addStudent(tempStudent);

		
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
