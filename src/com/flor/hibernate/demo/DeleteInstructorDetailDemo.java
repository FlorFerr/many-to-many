package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.entity.Instructor;
import com.flor.entity.InstructorDetail;




public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();	
	
	try {	
		session.beginTransaction();

		int instructorId = 3;
		
		InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, instructorId);
		
		
		tempInstructorDetail.getInstructor().setInstructorDetail(null);;
		session.delete(tempInstructorDetail);
		
		session.getTransaction().commit();
	
		
	}catch(Exception exc){
		exc.printStackTrace();
		
	}
	finally {
		
		session.close();
		factory.close();
		}
	}
}
