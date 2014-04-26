package LibrarySystem;
/*
 * search screen which is appear after login successful.
 * in page labraian can perform there task by click on menu 
 * menu items are dime at moment - mean nothing when u click.
 * need to add Action listen 
 * 
 * 
 * */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class SearchScreen extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Declaring the all attributes so other methods can able to access
	JButton bsearch,exit;
	JTextField search;
	JPanel bpanel,searchpanel;
	JLabel lsearch;
	//BSresult bs = new BSresult();
	Menubar mb  = new Menubar();
	JMenuBar menubar = new JMenuBar();
	

	
	
	public SearchScreen()
	{
		Container contentPane = getContentPane();
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		contentPane.setLayout(null);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Library management system");							//setting the title of panel
		setSize(800,500);												//setting the size of panel
		setLocation(20,20);												//setting the location of screen to start
		setResizable(false);											//setting resizeable to false
		
		setJMenuBar(menubar);
		menubar.add(mb.bookMenu());
		menubar.add(mb.customerMenu());
		menubar.add(mb.logoutMenu());
		

		lsearch = new JLabel("Search");
		lsearch.setBounds(150,50,50,30);
		
		search = new JTextField();
		search.setBounds(200,52,400,25);
		search.setToolTipText("search here by name,isbn, or anything");
		
		
		bsearch = new JButton("Search");
		bsearch.setBounds(580, 420, 80, 20);
		bsearch.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.setBounds(670, 420, 80, 20);
		exit.addActionListener(this);
		
		
		
		 
		
		add(lsearch);
		add(search);
		add(bsearch);
		add(exit);
		setVisible(true);
		
		
	}
	
		
	public void actionPerformed (ActionEvent e)
	{
	
		if(e.getSource()== exit)
		{
			System.exit(0);
			
			
		}
		if(e.getSource()== bsearch)
		{
			
			setVisible(false);
			
		 try {
			new BSresult(search.getText());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
		
	}
	
	public static void main(String arg[])
	{
		
		new SearchScreen();
	}
}
