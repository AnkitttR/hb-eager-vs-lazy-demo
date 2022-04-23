package com.luv2code.hibernate.demo.entity;

import java.security.PublicKey;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	//define our fields
	
	//define constructors
	
	//define getter setters
	
	//define toString
	
	//annotate fields 
	
	private int id;
	
	private String title;
	
	private Instructor instructor;
	
	public Course() {  //No argument constructor
			
	}

	public Course(String title) {
		this.title = title;
	}
}
