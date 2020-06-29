package LibraryManagementSystem;


import LibraryManagementSystem.DB;
import java.sql.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class StudentDao {
	
	public static int save(String username,String password,String f_name,String l_name, String P_no, String email, Date DOJ,int noOfMonths){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into students(username, password, f_name , l_name, phone_no, email , DOJ, no_of_months) values(?,?,?,?,?,?,?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,f_name);
			ps.setString(4,l_name);
			ps.setString(5,P_no);
			ps.setString(6, email);
			ps.setDate(7, DOJ);
			ps.setInt(8, noOfMonths);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static ResultSet view(String selectedForSearch, String searchfield){
		
	
		try{
			Connection con=DB.getConnection();
			Statement stmt=con.createStatement();  
			//step4 execute query  
			System.out.println("select username,  password , f_name, l_name, phone_no, email , DOJ, no_of_months from students where "+selectedForSearch+"= "+searchfield);
			ResultSet rs = stmt.executeQuery("select username,  password , f_name, l_name, phone_no, email , DOJ, no_of_months from students where "+selectedForSearch+"= '"+searchfield+"'");
			
		    /*PreparedStatement  ps = con.prepareStatement("select emp_id,  f_name , l_name, P_no, email , DOJ, Shift  from librarian where ? = ? ");
			ps.setString(1,selectedForSearch);
			ps.setString(2,searchfield);
			ResultSet rs = ps.executeQuery();*/
			//con.close();
			return rs;
			
		}catch(Exception e){System.out.println(e);}
			return null;
		}

	
}
