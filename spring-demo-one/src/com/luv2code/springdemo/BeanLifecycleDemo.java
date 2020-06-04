package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemo {

	public static void main(String[] args) {
		//load spring config
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanLifecycle-applicationcontext.xml");
		
		
		
		//retrieve bean from spring container
		Coach theCoach=context.getBean("myCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
		
		

	}

}

