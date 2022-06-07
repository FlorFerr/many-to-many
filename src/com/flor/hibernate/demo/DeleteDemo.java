package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.entity.Instructor;
import com.flor.entity.InstructorDetail;




public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();	
	
	try {	
		session.beginTransaction();
		//Crear el id
		int instructorId = 2;
		
		Instructor tempInstructor = session.get(Instructor.class, instructorId);
		
		if(tempInstructor != null) {
			System.out.println("Deleting: " + tempInstructor);
			session.delete(tempInstructor);
		}
				
		
		
	
		
		
		session.getTransaction().commit();
	
		
	}
	finally {
		factory.close();
		}
	}
}
