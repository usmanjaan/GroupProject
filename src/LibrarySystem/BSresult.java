package LibrarySystem;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class BSresult {
   
	JButton edit,loan,delete,exit;
	ImageIcon image;
	final JTable table;
	final JFrame frame;
	JDialog dialog;
	String title,author,isbn,simage,available,title1,author1,image1,savailable,sisbn = null;
	int available1,isbn1,isbnumber,iavailable;
	int textSize = 20;
	String[] fields = {"Title", "ISBN", "Author", "Image" ,"Available"};
	String[] results = {"null", "null", "null", "null","null"};
	JPanel panel,dialogPanel,ButtonPanel;
	JTextField[] texts = {new JTextField(20), new JTextField(textSize), new JTextField(textSize), 
	    				  new JTextField(textSize), new JTextField(textSize)};
   
	dbManager db= new dbManager(); 
	
	public BSresult(String text) throws ClassNotFoundException {
		frame = new JFrame("Result");
		panel = new JPanel();
		ArrayList<String[]>  tableData=new ArrayList<>();
		tableData = db.getAllBook(text);
		
		String[][] tableRows = tableData.toArray(new String[tableData.size()][]); // convert the ArrayList to a regular Array

		String[] columnNames =  {"title","author","isbn","image","available"};
		table = new JTable( tableRows, columnNames );  

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
				new dialogs();

			  }
			
			
		  });
		  
		 
		  
		// TODO Auto-generated constructor stub
	}
	
	public class dialogs extends JDialog implements ActionListener
	{
		   
		public dialogs()
		{
		   //getting which row is selected to identify the data.
			int row = table.getSelectedRow();
		   //getting data from table which row is selected
		   title = (String) table.getValueAt(row, 0);
		   author = (String) table.getValueAt(row, 1);
		   isbn = (String) table.getValueAt(row, 2);
		   simage = (String) table.getValueAt(row, 3);
		   available = (String) table.getValueAt(row, 4);
		  
		   //converting string to integer
		   isbnumber = Integer.parseInt(isbn);
		   iavailable =  Integer.parseInt(available);
		  
		   //creating the panel for dialog where text and label are placed
		   dialogPanel = new JPanel();
		   dialogPanel.setLayout(new GridLayout(6, 1));
	        
	       
		   for (int i = 0; i < 5; i++) {
	        	JPanel temp = new JPanel();
	        	temp.add(new JLabel(fields[i]));
	        	temp.add(texts[i]);
	        	dialogPanel.add(temp);
	        }
	        
		   //setting the textfield to their data 
		  texts[0].setText(title);
		  texts[1].setText(author);
		  texts[2].setText(isbn);
		  texts[3].setText(simage);
		  texts[4].setText(available);
		  
		  //getting the data from textfield for updating the book
		  title1 = texts[0].getText();
		  author1 = texts[1].getText();
		  sisbn = texts[2].getText();
		  image1 = texts[3].getText();
		  savailable = texts[4].getText();
		  
		 //converting string to integer
		  isbn1 = Integer.parseInt(sisbn);
		  available1 = Integer.parseInt(savailable);
		 
		  //creating panel for buttons
		  ButtonPanel = new JPanel();
		  ButtonPanel.setLayout(new GridLayout(1, 4));
		  
		  edit = new JButton("Edit");
		  edit.addActionListener(this);						//adding action listener to button
		  delete = new JButton("Delete");
		  delete.addActionListener(this);
		  loan = new JButton("Loan");
		  loan.addActionListener(this);
		  exit = new JButton("Exit");
		  exit.addActionListener(this);
		  
		  //adding buttons to panel
		  ButtonPanel.add(edit);
		  ButtonPanel.add(delete);
		  ButtonPanel.add(loan);
		  ButtonPanel.add(exit);
		  
		  //adding button panel to dialog panel
		  dialogPanel.add(ButtonPanel);
		  
		   dialog = new JDialog();
		  //dialog.setLocationRelativeTo(frame);
		  dialog.setModal(true);
		  dialog.setTitle(title);
		  dialog.pack();
		  dialog.setSize(310,300);
		  dialog.setLocation(100,100);
		  dialog.add(dialogPanel);
		  dialog.setResizable(false);
		  dialog.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()== exit)
			{
				 dialog.setVisible(false);	
			}
			if(e.getSource()==delete)
			{
				db.removeBook(isbnumber);
				JOptionPane.showMessageDialog(null,"successful deleted"+title);
			}
			if(e.getSource()==loan)
			{
				db.subtractAvailable(isbnumber, iavailable);
				JOptionPane.showMessageDialog(null,"successfully loaned"+title);
			
			}
			if(e.getSource()==edit)
			{
				db.updateBook(title1, author1, image1, available1, isbn1);
				JOptionPane.showMessageDialog(null,"successfully updated"+title);
			}
		}
	}
	
}
