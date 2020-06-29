package LibraryManagementSystem;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookDao {

	public BookDao() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	public static int insertBook(String name, String author, String publisher, int issue, String genre, int noOfCopies){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Books(name, author, publisher , issue, genre, noOfCopies) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,author);
			ps.setString(3,publisher);
			ps.setInt(4,issue);
			ps.setString(5,genre);
			ps.setInt(6, noOfCopies);
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
			System.out.println("select name,  author , publisher, issue, genre , noOfCopies  from Books where "+selectedForSearch+"= "+searchfield);
			ResultSet rs = stmt.executeQuery("select name,  author , publisher, issue, genre , noOfCopies  from Books where "+selectedForSearch+"= '"+searchfield+"'");
			
		    /*PreparedStatement  ps = con.prepareStatement("select emp_id,  f_name , l_name, P_no, email , DOJ, Shift  from librarian where ? = ? ");
			ps.setString(1,selectedForSearch);
			ps.setString(2,searchfield);
			ResultSet rs = ps.executeQuery();*/
			//con.close();
			return rs;
			
		}catch(Exception e){System.out.println(e);}
			return null;
		}
	
	/*public static int upDateBook(String name, String author, String publisher, int issue, String genre, int noOfCopies){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Books(name, author, publisher , issue, genre, noOfCopies) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,author);
			ps.setString(3,publisher);
			ps.setInt(4,issue);
			ps.setString(5,genre);
			ps.setInt(6, noOfCopies);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}*/
	
	

}
