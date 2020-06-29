package LibraryManagementSystem;

import LibraryManagementSystem.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class issueBookDao {
	public static int issueBook(String book_name, String author, int issue, String username){
		int status=0;
		try{
			Connection con=DB.getConnection();
			
			Statement stmt=con.createStatement();  
			
			ResultSet rs = stmt.executeQuery("select count(*) from issueBook where book_name = '"+book_name+"'");
			
			int a = 0;
			while(rs.next()){
				System.out.println(rs.getInt(1));
				a = rs.getInt(1);
			}
			ResultSet rs1 = stmt.executeQuery("select noOfCopies from books where name = '"+book_name+"'");
			int b = 0;
			while(rs1.next()){
				
				System.out.println(rs1.getInt(1));
				b = rs1.getInt(1);
			}
			System.out.println(username + ", "+b);
			PreparedStatement ps;
			if( a < b ){
				
				ps = con.prepareStatement("insert into issueBook(book_name, author, Issue, username) values(?,?,?,?)");
				ps.setString(1,book_name);
				ps.setString(2,author);
				ps.setInt(3,issue);
				ps.setString(4, username);
				status=ps.executeUpdate();
				
			} else {
				System.out.println("No Books left");
			}
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int returnBook(String book_name, String author, int issue, String username){
		int status=0;
		
		Connection con=DB.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from issueBook where book_name = '"+book_name+"'AND author = '"+author+"'AND Issue = "+issue+" AND username = '"+username+"'");
			/*ps.setString(1, book_name);
			ps.setString(2, author);
			ps.setInt(3, issue);
			ps.setString(4, username);*/
			status=ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
}
