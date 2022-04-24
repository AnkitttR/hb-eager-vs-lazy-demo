package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

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
				
			//create the objects
			
			//Instructor class mein value insert karenge
			Instructor tempInstructor = new Instructor("Susan","Public","susan.public@luv2code.com");
			
			//InstructorDetail class mein value insert karenge
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youtube.com","Video Games");
			
			
			//Debugging Code
			System.out.println(tempInstructor);
			System.out.println(tempInstructorDetail);
			
			
			
			//Hey tempInstructor please set InstructorDetail to whatever is mentioned in tempInstructorDetail & join both of them
			//After joining Instructor & InstructorDetail store them in Instructor
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
						
			//save the instructor
			//
			//Note: this will ALSO save the details(Associated) object
			//because of CascadeType.ALL
			//
			System.out.println("Saving instructor:" + tempInstructor);
			session.save(tempInstructor); //
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			
			//add clean up code
			session.close();
			
			factory.close();
		}
	}

}
