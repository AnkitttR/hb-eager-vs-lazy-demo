package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class FetchJoinDemo {

	public static void main(String[] args) {
		

		//create session factory
		SessionFactory factory = new Configuration()
				                        .configure("hibernate.cfg.xml")
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetail.class)
				                        .addAnnotatedClass(Course.class)
				                        .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		//factory is object of "SessionFactory Interface"
		//getCurrentSession() is method placed in "SessionFactory Interface"
		
		try {
				
			
			
			//start a transaction
			session.beginTransaction();
			
			//option2: Hibernate query with HQL
			
			//get the instructor from db
			int theId = 1;
			
			
			//Debugging Code
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			
			
			// Path: tempInstructor (obj of Instructor) >> getCourses() method in instructor
			//commit transaction
			session.getTransaction().commit();
			System.out.println("luv2code: Done!");
			
		}
		finally {
			
			//add clean up code
			session.close();
			
			factory.close();
		}
	}

}
