package LibraryManagementSystem;


import java.sql.*;

public class DB {

	
		public static Connection getConnection(){
			Connection con=null;
			
			try{
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nsic","root","nsic@123");
				
				
			}
			catch(Exception s){
				System.out.println(s);
			}
			return con;
		}

	}



