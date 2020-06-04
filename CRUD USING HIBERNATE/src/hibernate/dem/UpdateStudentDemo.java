package hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create Session factory
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			int studentId=1;
						
			
			
			//now get a new session and start a new transaction 
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id:PK
			System.out.println("\n Getting student Id: "+studentId);
			
			Student myStudent=session.get(Student.class, studentId);
			System.out.println("Updating Student.... ");
			myStudent.setFirstName("Akhil");
			
			//commit the transaction
			session.getTransaction().commit();
			
			//New Code
			//begin transaction
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			//update email for all students
			System.out.println("update email for particular student");
			session.createQuery("update Student s set s.email='abhi@gmail.com' where s.firstName='Abhinay'").executeUpdate();
			
			
			//commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
		

	}

}
