package hibernate.dem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo2 {

	public static void main(String[] args) {
		//create Session factory
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session=factory.getCurrentSession();
try {
			
			
			//start a transaction
			session.beginTransaction();
			
			//query the students
			List<Student>theStudent=session.createQuery("from Student").getResultList();
			
			//display the students
			
			displayStudents(theStudent);
			
			
			//query students :lastname"abhi
			
			theStudent=session.createQuery("from Student s where s.lastName='koppera'").getResultList();
			//display the name with koppera
			
			System.out.println("\n\n students with koppera");
			displayStudents(theStudent);
			
			//new query statements for lastname or firstname
			
			theStudent=session.createQuery("from Student s where s.lastName='koppera' OR s.firstName='Abhinay'").getResultList();
			System.out.println("\n\n students with Koppera Abhinay");
			displayStudents(theStudent);
			
			//query students where email like gmail.com
			theStudent= session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\n students with gmail.com");
			displayStudents(theStudent);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
		

	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
