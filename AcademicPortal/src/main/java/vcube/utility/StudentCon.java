package vcube.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentCon {

    //public static Connection DBconnection() throws SQLException, ClassNotFoundException {

        
        //Class.forName("com.mysql.cj.jdbc.Driver");

       
        //String url = "jdbc:mysql://localhost:3306/lms?useSSL=false&serverTimezone=UTC";
       // String user = "root";       
       // String password = "sahithi";    

       // Connection con = DriverManager.getConnection(url, user, password);
        //System.out.println("Database connected successfully!");

       // return con;
   // }
	public static Connection DBconnection() throws SQLException, ClassNotFoundException {

	    Class.forName("com.mysql.cj.jdbc.Driver");

	    String url = "jdbc:mysql://localhost:3306/lms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	    String user = "root";
	    String password = "sahithi";

	    Connection con = DriverManager.getConnection(url, user, password);
	    System.out.println("Database connected successfully!");

	    return con;
	}
}


