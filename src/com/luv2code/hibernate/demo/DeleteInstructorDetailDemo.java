package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;


public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		

		//create session factory
		SessionFactory factory = new Configuration()
				                        .configure("hibernate.cfg.xml")
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetail.class)
				                        .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession(); //factory ke under hai CurrentSession
		
		try {
				
			
			//start a transaction
			session.beginTransaction();
						
			//get the instructor detail object
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("tempInstructorDetails: " + tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor: " + 
														tempInstructorDetail.getInstructor()) ;
			
			// now let's delete the instructor detail
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			
			//remove the associated object reference to
			//break bi-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null); //InstructorDetail jodne wali kadi hai
														// Usi ko null kar diya, matlab Instructor & InstructorDetail 
														// ka link tod diya
			
			
			session.delete(tempInstructorDetail); //Ab safely InstructorDetail ko delete kar sakte hain
								//Iska koi effect Instructor pe nahi pada
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
