package LibraryManagementSystem;


import LibraryManagementSystem.DB;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class LibrarianDao {

	public LibrarianDao() {
		// TODO Auto-generated constructor stub
	}
	public static int save(int emp_id,String password,String f_name,String l_name, String P_no,String email, Date DOJ,String Shift){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into librarian(emp_id, password, f_name , l_name, P_no, email , DOJ, Shift) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1,emp_id);
			ps.setString(2,password);
			ps.setString(3,f_name);
			ps.setString(4,l_name);
			ps.setString(5,P_no);
			ps.setString(6, email);
			ps.setDate(7, DOJ);
			ps.setString(8, Shift);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static ResultSet view(String selectedForSearch, String searchfield){
		int status=0;
	
		try{
			Connection con=DB.getConnection();
			Statement stmt=con.createStatement();  
			//step4 execute query  
			System.out.println("select emp_id,  f_name , l_name, P_no, email , DOJ, Shift  from librarian where "+selectedForSearch+"= "+searchfield);
			ResultSet rs = stmt.executeQuery("select emp_id,  f_name , l_name, P_no, email , DOJ, Shift  from librarian where "+selectedForSearch+"= '"+searchfield+"'");
			
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

