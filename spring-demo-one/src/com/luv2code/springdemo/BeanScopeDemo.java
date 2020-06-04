package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {
		//load spring config
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanScopeapplicationcontext.xml");
		
		
		
		//retrieve bean from spring container
		Coach theCoach=context.getBean("myCoach",Coach.class);
		Coach theAlphaCoach=context.getBean("myCoach",Coach.class);
		boolean result=(theCoach==theAlphaCoach);
		//print out results
		System.out.println("\n pointing to the same object: " + result);
		
		System.out.println("\n memory location for the coach: "+ theCoach);
		
		System.out.println("\n memory location for the coach: "+ theAlphaCoach+"\n" );
		
		context.close();
		
		

	}

}

