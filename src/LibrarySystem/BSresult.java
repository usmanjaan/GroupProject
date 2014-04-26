package LibrarySystem;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;


public class BSresult {
   
	JButton edit,loan,delete;
	JLabel title,label1,limage;
	JTextField tf1,tf2,tf3;
	ImageIcon image;
	 
	  int len = 5;
	    int textSize = 20;
	    String[] fields = {"Title", "ISBN", "Author", "Image" ,"Available"};
	    JTextField[] texts = {new JTextField(textSize), 
	        new JTextField(textSize), 
	        new JTextField(textSize), 
	        new JTextField(textSize), 
	        new JTextField(textSize)};
	    // used to access submitted values
	    String[] results = {"null", "null", "null", "null","null"};
	
	public BSresult(String text) throws ClassNotFoundException {
		final JFrame frame = new JFrame("Creating a Scrollable JTable!");
		  JPanel panel = new JPanel();

		dbManager db= new dbManager();
		//String jsearch = "DaVinci Code";//ss.search.getText();
		//System.out.print(jsearch);
		ArrayList<String[]>  tableData=new ArrayList<>();
		 
		 tableData = db.getAllBook(text);
		
		String[][] tableRows = tableData.toArray(new String[tableData.size()][]); // convert the ArrayList to a regular Array

		
		 
		String[] columnNames =  {"title","author","isbn","image","available"};
		final JTable table = new JTable( tableRows, columnNames );  
		
		String dd = Arrays.deepToString(tableRows).replaceAll("\r", "\n");
		System.out.print(dd);
		
		
		
		
		JTableHeader header = table.getTableHeader();
		 header.setBackground(Color.yellow);
		  JScrollPane pane = new JScrollPane(table);
		  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  panel.add(pane);
		  frame.add(panel);
		  frame.setSize(500,150);
		  frame.setUndecorated(true);
		  frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);

		  table.addMouseListener(new MouseAdapter(){
			  public void mouseClicked(MouseEvent e)
			  {
				
				  
				 
				  
				/*main dialog frame
			        JPanel pan = new JPanel();
			        pan.setLayout(new GridLayout(7, 1));
			        // dialog title
			        pan.add(new JLabel("Add New Book"));
			       
			        
			        for (int i = 0; i < len; i++) {
			        	JPanel temp = new JPanel();
			        	temp.add(new JLabel(fields[i]));
			        	
			        	temp.add(texts[i]);
			        	
			        	pan.add(temp);
			        }
				  
			        int selectedRowIndex = table.getSelectedRow();
			        int selectedColumnIndex = table.getSelectedColumn();

			        Object ty = table.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
			        		//texts[0].set
			        		
			        JDialog dialog = new JDialog();
					  dialog.setLocationRelativeTo(frame);
					  dialog.setSize(300, 300);
					  dialog.setModal(true);
					  dialog.setTitle("row clicked");
					  dialog.pack();
					  dialog.add(pan);
					  dialog.setVisible(true);*/
				  
				  int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				  Object data =  table.getModel().getValueAt(row, column);
				  
				  
				  JPanel jp = new JPanel(); 
				
				jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
				jp.setSize(200, 200);
				 image = new ImageIcon();
				 limage = new JLabel(image);
				 limage.setBounds(10,10,20,20);
				  
				  title = new JLabel("Title");
				  title.setBounds(20, 20, 30, 30);
				  tf1 = new JTextField();
				  tf1.setBounds(40,40,30,40);
				
				  JDialog dialog = new JDialog();
				  dialog.setLocationRelativeTo(frame);
				  dialog.setSize(300, 300);
				  dialog.setModal(true);
				  dialog.setTitle("row clicked");
				  dialog.pack();
				 
				  jp.add(limage);
				  jp.add(title);
				  jp.add(tf1);
				  dialog.add(jp);
				  dialog.setVisible(true);
				  System.out.print("yes");
			  }
		  });
		  
		// TODO Auto-generated constructor stub
	}
	
	
}
