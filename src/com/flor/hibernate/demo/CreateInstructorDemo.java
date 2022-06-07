package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.entity.Course;
import com.flor.entity.Instructor;
import com.flor.entity.InstructorDetail;




public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();	
	
	try {
		//Crear los objetos
		Instructor tempInstructor = new Instructor("Jose", "Perez", "josep@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("Josep", "Guitar");
		
		//Asociar los objetos
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		session.beginTransaction();
		
		session.save(tempInstructor);
		
		
		session.getTransaction().commit();
	
		
	}
	finally {
		session.close();
		factory.close();
		}
	}
}
