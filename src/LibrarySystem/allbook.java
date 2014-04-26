package LibrarySystem;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;


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


public class allbook {
   
	JButton edit,loan,delete;
	JLabel title,label1,limage;
	JTextField tf1,tf2,tf3;
	ImageIcon image;
	
	public allbook(){
		final JFrame frame = new JFrame("All Books");
		  JPanel panel = new JPanel();

		dbManager db= new dbManager();
		db.getConnection();
		//String jsearch = "DaVinci Code";//ss.search.getText();
		//System.out.print(jsearch);
		
		
		ArrayList<String[]>  tableData=new ArrayList<>();
		 try{
			 tableData = db.AllBook();
		 }catch(Exception e)
		 {
			 
		 }
		 
		
		String[][] tableRows = tableData.toArray(new String[tableData.size()][]); // convert the ArrayList to a regular Array

		String[] columnNames =  {"title","author","isbn","image","available"};
		final JTable table = new JTable( tableRows, columnNames );
		
		//JTableHeader header = table.getTableHeader();
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
				 int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				  Object[][] data = (Object[][]) table.getValueAt(row, column);
				  String string = new String().toString();
				  string.valueOf(data);
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
				  tf1.setText(string);
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
