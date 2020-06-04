package abhi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			System.out.println("connecting to database"+ jdbcurl);
			Connection Conn=DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("Connection Successful!!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
