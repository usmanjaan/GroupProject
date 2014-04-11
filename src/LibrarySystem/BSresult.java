package LibrarySystem;


import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BSresult {
    static JTable mysTable;
    
    ResultSet resultset;
	Statement statement;
	
	public void getConnection() {
		
		DefaultTableModel model = new DefaultTableModel();
		model.addRow(new Object[]{"loan","edit"});

		String [] columnNames = {"title","author","isbn","image","copies"};
		 mysTable = new JTable(6,6);
		 mysTable.setBounds(20,10,300,300);
		 JScrollPane scroll = new JScrollPane(mysTable);
		
		 mysTable(model);  
		 
		 JFrame frame = new JFrame("King Musa Saloon Software");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setLayout(null);
		    frame.setSize(500,500);
		    frame.setResizable(false);
		       frame.setVisible(true);
		        frame.add(mysTable);
		        frame.add(scroll);

		
		String dB_URL = "jdbc:mysql://localhost/library"; // database url
		String db_Name = "root";
		String password = "";
		resultset = null;
		statement = null;		

		java.sql.Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(dB_URL, db_Name, password);			
			Class.forName("com.mysql.jdbc.Driver");
			
			statement = con.createStatement();
			resultset = statement.executeQuery("Select * from book");
			int li_row = 0;
			while(resultset.next())
				{
				
					mysTable.setValueAt(resultset.getString("title"),li_row,0);
					mysTable.setValueAt(resultset.getString("author"),li_row,1);
					mysTable.setValueAt(resultset.getString("isbn"),li_row,2);
					mysTable.setValueAt(resultset.getString("image"),li_row,3);
					mysTable.setValueAt(resultset.getString("available"),li_row,4);
					
					li_row++;
				}
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println("No database connection found");
		}

		//return con;
	}

	private void mysTable(DefaultTableModel model) {
		// TODO Auto-generated method stub
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.addRow(new Object[]{"loan","edit"});
		
	}

	public static void main(String args[]) 
	{
		
		BSresult bs = new BSresult ();
		bs.getConnection();
		
	}
}
