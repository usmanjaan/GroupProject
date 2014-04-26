package LibrarySystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class dbManager {

	Connection con;
	String dB_URL = "jdbc:mysql://localhost/library"; // database url
	String db_Name = "root";
	String password = "";
	ResultSet resultset = null;

	public void getConnection() {

		String dB_URL = "jdbc:mysql://localhost/library"; // database url
		String db_Name = "root";
		String password = "";
		con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dB_URL, db_Name, password);
		}

		catch (SQLException | ClassNotFoundException e) {
			System.out.println("No database connection found");
		}

	}

	public void close() {
		try {
			con.close();
			System.out.println("DB closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet viewBook() {

		ResultSet resultset = null;
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("Select * from book");
			resultset = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultset;
	}

	public ResultSet searchBook(String input){
		ResultSet resultset = null;
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("Select * from book where title like ? or author like ?");
			statement.setString(1, "%" + input + "%");
			statement.setString(2, "%" + input + "%");
			resultset = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultset;
	}
	
	public void addBook(String title, int isbn, String author, String image, int available) {

		PreparedStatement statement = null;

		try {
			statement = con
					.prepareStatement("insert into library.book values (?, ?, ?, ?, ?)");
			statement.setString(1, title);
			statement.setInt(2, isbn);
			statement.setString(3, author);
			statement.setString(4, image);
			statement.setInt(5, available);
			statement.executeUpdate();
			System.out.println("Inserted Succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateBook(String title, String author, String image, int available, int ISBN) {

		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("update library.book set title = ?, author = ?, image = ?, available = ? where isbn = ?");
			statement.setString(1, title);
			statement.setString(2, author);
			statement.setString(3, image);
			statement.setInt(4, available);
			statement.setInt(5, ISBN);
		
			statement.executeUpdate();
			System.out.println("Updated Succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeBook(int ISBN) {
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("delete from library.book where isbn = ?");
			statement.setInt(1, ISBN);
		
			statement.executeUpdate();
			System.out.println("Delete Succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addAvailable(int ISBN, int num) {
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("update library.book set available = available + ? where isbn = ?");
			statement.setInt(1, num);
			statement.setInt(2, ISBN);
		
			statement.executeUpdate();
			System.out.println("Updated available Succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void subtractAvailable(int ISBN, int num) {
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("update library.book set available = available - ? where isbn = ?");
			statement.setInt(1, num);
			statement.setInt(2, ISBN);
		
			statement.executeUpdate();
			System.out.println("Updated available Succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ResultSet viewUsers() {
		
		ResultSet resultset = null;
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("Select * from users");
			resultset = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultset;
	}

	public void addUser(String uname, String pwd, String fname, String lname, String email, int active) {
		
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("insert into library.users values (DEFAULT, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, uname);
			statement.setString(2, pwd);
			statement.setString(3, fname);
			statement.setString(4, lname);
			statement.setString(5, email);
			statement.setInt(6, active);
			statement.executeUpdate();
			System.out.println("Inserted Succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateUser(int uid, String uname, String pwd, String fname, String lname, String email) {
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("update library.users set username = ?, password = ?, firstname = ?, lastname = ?, email = ? where user_id = ?");
			statement.setString(1, uname);
			statement.setString(2, pwd);
			statement.setString(3, fname);
			statement.setString(4, lname);
			statement.setString(5, email);
			statement.setInt(6, uid);
		
			statement.executeUpdate();
			System.out.println("Updated Succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeUser(int uid) {
		
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement("delete from library.users where user_id = ?");
			statement.setInt(1, uid);
		
			statement.executeUpdate();
			System.out.println("Delete Succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void loanBook(){
		Statement statement = null;
		try{
			statement = con.createStatement();
			String query = "SELECT * FROM currentlyLoaned where SYSDATE() > return_date";
			resultset = statement.executeQuery(query);
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	public void returnBook(){
	}
	public String getPassword(String us) throws ClassNotFoundException {
		String pass  = null;
		ResultSet resultset = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dB_URL, db_Name, password);
					statement = con.prepareStatement("SELECT * FROM `users` where username = ?");
					statement.setString(1, us);
					resultset = statement.executeQuery();
			while(resultset.next()){
				 pass = resultset.getString("password");
				
			}
		}

		catch (SQLException  e) {
			System.out.println("No database connection found");
		}
				return pass;
	}

	public ArrayList<String[]> AllBook() throws ClassNotFoundException {
		ResultSet resultset = null;
		PreparedStatement statement = null;
		ArrayList<String[]>  tableData=new ArrayList<>();
		try {
			
			statement = con.prepareStatement("Select * from book");
			resultset = statement.executeQuery();
			
			while(resultset.next()){
			 tableData.add(new String[]{resultset.getString("title"),resultset.getString("author"),		
				resultset.getString("isbn"),resultset.getString("image"),resultset.getString("available")});
				
			}
		}

		catch (SQLException  e) {
			System.out.println("No database connection found");
		}
				return tableData;
	}
	
	public ArrayList<String[]> getAllBook(String bo) throws ClassNotFoundException {
		ResultSet resultset = null;
		PreparedStatement statement = null;
		ArrayList<String[]>  tableData=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dB_URL, db_Name, password);
					String query = "SELECT * FROM `book` where title like ?";
					statement = con.prepareStatement(query);
					statement.setString(1, "%" + bo + "%");
					resultset = statement.executeQuery();
		
			resultset = statement.executeQuery();
			
			while(resultset.next()){
			 tableData.add(new String[]{resultset.getString("title"),resultset.getString("author"),		
				resultset.getString("isbn"),resultset.getString("image"),resultset.getString("available")});
				
			}
		}

		catch (SQLException  e) {
			System.out.println("No database connection found");
		}
				return tableData;
	}
	
	
	
	public ArrayList<String[]> BonLoanToUsers() throws ClassNotFoundException {
		ResultSet resultset = null;
		PreparedStatement statement = null;
		ArrayList<String[]>  tableData=new ArrayList<>();
		try {
			
			statement = con.prepareStatement("SELECT users.username, currentlyLoaned.LoanID, currentlyLoaned.ISBN, currentlyLoaned.date_loaned, currentlyLoaned.return_date FROM users INNER JOIN currentlyLoaned ON users.user_id = currentlyLoaned.user_id");
			resultset = statement.executeQuery();
			
			
			while(resultset.next()){
			 tableData.add(new String[]{resultset.getString("username"),resultset.getString("title"),resultset.getString("author"),		
				resultset.getString("isbn"),resultset.getString("image"),resultset.getString("available")});
				
			}
		}

		catch (SQLException  e) {
			System.out.println("No database connection found");
		}
				return tableData;
	}
	
	
	public String getBook(String bo) throws ClassNotFoundException {
		ResultSet resultset = null;
		PreparedStatement statement = null;
		String tableData=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dB_URL, db_Name, password);
					String query = "SELECT * FROM `book` where title like ?";
					statement = con.prepareStatement(query);
					statement.setString(1, "%" + bo + "%");
					resultset = statement.executeQuery();
		
			resultset = statement.executeQuery();
			
			while(resultset.next()){
			 //tableData.add(resultset.getString("title"),resultset.getString("author"),		
				//resultset.getString("isbn"),resultset.getString("image"),resultset.getString("available")});
				tableData = resultset.getString("title");
				tableData = resultset.getString("author");
				tableData = resultset.getString("isbn");
				tableData = resultset.getString("image");
				tableData = resultset.getString("available");
				
				
			}
		}

		catch (SQLException  e) {
			System.out.println("No database connection found");
		}
				return tableData;
	}
	
	
	
	
}
