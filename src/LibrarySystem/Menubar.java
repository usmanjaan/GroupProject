package LibrarySystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Menubar implements ActionListener {
	JMenuItem newbook,editbook,retirebook,allbook,bookloan,odbook,
	addcust,editcust,delcust,scult,allcult,cwbol,cwob,
	lbook,rbook,allloan,oloan;
	JMenu book,customer,loan,logout;
	/**
	 * @param args
	 */
	public JMenu bookMenu()
	{
		 book = new JMenu("Books");
		 JMenu bookview = new JMenu("View");										//sub menu for View
		
		//craete the menu item "new"
		newbook = new JMenuItem("Add new book");
		editbook = new JMenuItem("Edit exiting book");
		retirebook = new JMenuItem("Retire book");
		allbook = new JMenuItem("All books");
		bookloan = new JMenuItem("Books on loan"); 
		odbook = new JMenuItem("Overdue Books");
		
		JRadioButtonMenuItem viewButton = new JRadioButtonMenuItem();
		viewButton.add(bookview);
		
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
				
				//adding action listener to all the JMenuitems
			    newbook.addActionListener(this);
			    editbook.addActionListener(this);
			    retirebook.addActionListener(this);
			    allbook.addActionListener(this);
			    bookloan.addActionListener(this);
			    odbook.addActionListener(this);	
		return book;
		
	}
	
	public JMenu customerMenu()
	{
		customer = new JMenu("Customers");
		JMenu cultview = new JMenu("View");				//sub menu for customer
		
				//craete the menu item 
				addcust = new JMenuItem("Add customer");
				editcust= new JMenuItem("Edit customer");
				delcust= new JMenuItem("Delete customer");
				scult= new JMenuItem("Search customer");
				allcult= new JMenuItem("All customers");
				cwbol= new JMenuItem("Customers with books on loan");
				cwob = new JMenuItem("Customer with overdue books");
				
				// Create radio buttons, put them in a group and add to the book,customer and loan menu
				JRadioButtonMenuItem viewcultButton = new JRadioButtonMenuItem();
				viewcultButton.add(cultview);
				
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
				
				//adding action listener to all the JMenuitems 
				addcust.addActionListener(this);
				editcust.addActionListener(this);
				delcust.addActionListener(this);
				scult.addActionListener(this);
				allcult.addActionListener(this);
				cwbol.addActionListener(this);
				cwob.addActionListener(this);
				return customer;
	}

	public JMenu loanMenu()
	{

		loan = new JMenu("Loan");
		JMenu lview = new JMenu("View");				//sub menu for loan

			lbook = new JMenuItem("Lend book");
			rbook= new JMenuItem("Return book"); 
			allloan= new JMenuItem("All loans");
			oloan= new JMenuItem("Overdue Books");
		
		
			JRadioButtonMenuItem loanButton = new JRadioButtonMenuItem();
			loanButton.add(lview);

			//book menu items
			loan.add(lbook);
			loan.add(rbook);
			loan.add(lview);											
			lview.add(allloan);											
			lview.add(oloan);
	
			//adding action listener to all the JMenuitems 
			lbook.addActionListener(this);
			rbook.addActionListener(this);
			allloan.addActionListener(this);
			oloan.addActionListener(this);
			return loan;
		
	}
	
	public JMenu logoutMenu()
	{
		 return logout = new JMenu("Log out");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==logout)
		{
			
			
		}
		if(e.getSource()==newbook)
		{
			
		}
		if(e.getSource()==editbook)
		{
			
		}
		if(e.getSource()==retirebook)
		{
			
		}
		if(e.getSource()==bookloan)
		{
			
		}
		if(e.getSource()==odbook)
		{
			
		}
		if(e.getSource()==addcust)
		{
			
		}
		if(e.getSource()==editcust)
		{
			
		}
		if(e.getSource()==delcust)
		{
			
		}
		if(e.getSource()==scult)
		{
			
		}
		if(e.getSource()==allcult)
		{
			
		}
		if(e.getSource()==cwbol)
		{
			
		}
		if(e.getSource()==cwob)
		{
			
		}
		if(e.getSource()==lbook)
		{
			
		}
		if(e.getSource()==rbook)
		{
			
		}
		if(e.getSource()==allloan)
		{
			
		}
		if(e.getSource()==oloan)
		{
			
		}
	}

}
