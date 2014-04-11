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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;



public class SearchScreen extends JFrame implements ActionListener {
	
	//Declaring the all attributes so other methods can able to access
	JButton bsearch,exit;
	JTextField search;
	JPanel bpanel,searchpanel;
	JLabel lsearch;
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
		menubar.add(mb.logoutMenu());
		

		lsearch = new JLabel("Search");
		lsearch.setBounds(150,180,50,30);
		
		search = new JTextField();
		search.setBounds(200,185,400,25);
		search.setToolTipText("search here by name,isbn, or anything");
		
		bsearch = new JButton("Search");
		bsearch.setBounds(580, 400, 80, 20);
		bsearch.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.setBounds(670, 400, 80, 20);
		exit.addActionListener(this);
		
		add(lsearch);
		add(search);
		add(bsearch);
		add(exit);
		
		
	}
	
		
	public void actionPerformed (ActionEvent e)
	{
		
	}
	
	public static void main(String arg[])
	{
		SearchScreen w = new SearchScreen();
		w.setVisible(true);
	}
}
