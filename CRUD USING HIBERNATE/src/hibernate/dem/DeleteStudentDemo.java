package hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//create Session factory
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//int studentId=1;
						
			
			
			//now get a new session and start a new transaction 
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id:PK
			//System.out.println("\n Getting student Id: "+studentId);
			
			//Student myStudent=session.get(Student.class, studentId);
			
			//delete the student
			//System.out.println("Deleting Student "+myStudent);
			//session.delete(myStudent);
			
			//deleting the another student another way
			session.createQuery("delete from Student where id='3'").executeUpdate();
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
		

	}

}
