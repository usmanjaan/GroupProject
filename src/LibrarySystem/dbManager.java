package LibrarySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class dbManager {
	
	ResultSet resultset;
	Statement statement;
	
	public void getConnection() {

		String dB_URL = "jdbc:mysql://localhost/library"; // database url
		String db_Name = "root";
		String password = "";
		resultset = null;
		statement = null;		

		Connection con = null;
		try {
		
			JFrame frame = new JFrame();
			JTable table = new JTable();
			dbManager db = new dbManager();
			//db.getConnection();
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dB_URL, db_Name, password);
			statement = con.createStatement();
			resultset = statement.executeQuery("Select * from book");

			while(resultset.next()){
				String title = resultset.getString("title");
				int isbn = resultset.getInt("isbn");
				String author = resultset.getString("author");
				String image = resultset.getString("image");
				int available = resultset.getInt("available");

				System.out.println("Title: " + title);
				System.out.println("ISBN: " + isbn);
				System.out.println("Author: " + author);
				System.out.println("Image: " + image);
				System.out.println("Available: " + available + "\n");
			}
		}

		catch (SQLException | ClassNotFoundException e) {
			System.out.println("No database connection found");
		}

		//return con;
	}
	public static void main(String arg[])
	{
		
		 dbManager db = new dbManager();
		 db.getConnection();
		//l.setVisible(true);
		

	}
}
