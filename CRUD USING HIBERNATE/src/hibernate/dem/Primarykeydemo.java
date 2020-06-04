package hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class Primarykeydemo {

	public static void main(String[] args) {
		//create Session factory
				SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				
				//create session
				Session session=factory.getCurrentSession();
				
				try {
					//create 3 student objects
					System.out.println("Creating 3 new student objects.....");
					
					Student tempStudent1=new Student("Abhinay","Koppera","kopperaabhinay@gmail.com");
					Student tempStudent2=new Student("Harsha","reddy","hr@gmail.com");
					Student tempStudent3=new Student("bondam","Mani","mb@gmail.com");
					
					//start a transaction
					session.beginTransaction();
					//save the student object
					System.out.println("saving the student details");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!!");
					
				}
				finally {
					factory.close();
				}
				

	}

}
