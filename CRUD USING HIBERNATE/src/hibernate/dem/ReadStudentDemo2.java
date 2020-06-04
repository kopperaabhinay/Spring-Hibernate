package hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo2 {

	public static void main(String[] args) {
		//create Session factory
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating a new student object.....");
			
			Student tempStudent=new Student("Abhi","Kop","kaabhinay@gmail.com");
			
			
			//start a transaction
			session.beginTransaction();
			//save the student object
			System.out.println("saving the student details");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//my new code
			
			//find out the student's Id:primary key
			System.out.println("Saved student Id:" + tempStudent.getId());
			
			
			//now get a new session and start a new transaction 
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id:PK
			System.out.println("\n Getting student Id: "+tempStudent.getId());
			
			Student myStudent=session.get(Student.class, tempStudent.getId());
			System.out.println("get complete: "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
		

	}

}
