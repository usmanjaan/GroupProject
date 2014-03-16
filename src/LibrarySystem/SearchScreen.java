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
	JMenuItem newbook,editbook,retirebook,allbook,bookloan,odbook,
	addcust,editcust,delcust,scult,allcult,cwbol,cwob,
	lbook,rbook,allloan,oloan;
	
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
		setJMenuBar(createMenu());										//adding the createmenu method to menubar
	
		
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
	

	
	private JMenuBar createMenu()
	{

		//create the menu bar
		JMenuBar menubar = new JMenuBar();

		//build the three menu
		JMenu book = new JMenu("Books");
		JMenu customer = new JMenu("Customers");
		JMenu loan = new JMenu("Loan");
		JMenu lo = new JMenu("Log out");
		JMenu bookview = new JMenu("View");				//sub menu for book
		JMenu cultview = new JMenu("View");				//sub menu for customer
		JMenu lview = new JMenu("View");				//sub menu for loan


		//craete the menu item "new"
		newbook = new JMenuItem("Add new book");
		editbook = new JMenuItem("Edit exiting book");
		retirebook = new JMenuItem("Retire book");
		allbook = new JMenuItem("All books");
		bookloan = new JMenuItem("Books on loan"); 
		odbook = new JMenuItem("Overdue Books");
		
		
		addcust = new JMenuItem("Add customer");
		editcust= new JMenuItem("Edit customer");
		delcust= new JMenuItem("Delete customer");
		scult= new JMenuItem("Search customer");
		allcult= new JMenuItem("All customers");
		cwbol= new JMenuItem("Customers with books on loan");
		cwob = new JMenuItem("Customer with overdue books");
		
		

		lbook = new JMenuItem("Lend book");
		rbook= new JMenuItem("Return book"); 
		allloan= new JMenuItem("All loans");
		oloan= new JMenuItem("Overdue Books");
		
		// Create 3 radio buttons, put them in a group and add to the book,customer and loan menu
		JRadioButtonMenuItem viewButton = new JRadioButtonMenuItem();
		JRadioButtonMenuItem viewcultButton = new JRadioButtonMenuItem();
		JRadioButtonMenuItem loanButton = new JRadioButtonMenuItem();
		viewButton.add(bookview);
		viewcultButton.add(cultview);
		loanButton.add(lview);
		


		//adding the book menu items to menu
		book.add(newbook);
		book.addSeparator();													//adding a line as in design
		book.add(editbook);
		book.addSeparator();
		book.add(retirebook);
		book.addSeparator();
		book.add(bookview);														//adding items to sub menu
		bookview.add(allbook);													//adding items to sub menu
		bookview.addSeparator();
		bookview.add(bookloan);
		bookview.addSeparator();
		bookview.add(odbook);
		
		//customer menu items
		customer.add(addcust);
		customer.addSeparator();
		customer.add(editcust);
		customer.addSeparator();
		customer.add(delcust);
		customer.addSeparator();
		customer.add(scult);
		customer.addSeparator();
		customer.add(cultview);
		cultview.add(allcult);
		cultview.addSeparator();
		cultview.add(cwbol);
		cultview.addSeparator();
		cultview.add(cwob);
		
		//book menu items
		loan.add(lbook);
		loan.add(rbook);
		loan.add(lview);											
		lview.add(allloan);											
		lview.add(oloan);
		
	
		//add menu to menubar
		menubar.add(book);
		menubar.add(customer);
		menubar.add(loan);
		menubar.add(lo);
		return menubar;
	}

		
	
	public void actionPerformed (ActionEvent e)
	{
		if(e.getSource() == search)
		{
			
		}
		if(e.getSource()== exit)
		{
			System.exit(0);
		}
	}
	
	public static void main(String arg[])
	{
		SearchScreen w = new SearchScreen();
		w.setVisible(true);
	}
}
