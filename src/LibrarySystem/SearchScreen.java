package LibrarySystem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SearchScreen extends JFrame implements ActionListener {
	
	JButton bsearch,exit;
	JTextField search;
	JPanel bpanel,searchpanel;
	public SearchScreen()
	{
		// Set the title of the window
				super ("Search screen");
				// Set the default size of the window
				setSize(500,400);
				setLocation(300,500);
				setContentPane(createContentPane());
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				setVisible(true);
	}
	
	public Container createContentPane()
	{
		Container pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		bpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		searchpanel.setLayout(new GridLayout(2,0));
		
		bsearch = new JButton("Search");
		bsearch.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		search = new JTextField(20);
		search.setToolTipText("search here by name,isbn, or anything");
		
		bpanel.add(bsearch);
		bpanel.add(exit);
		
		searchpanel.add(search);
		pane.add(bpanel,BorderLayout.CENTER);
		pane.add(searchpanel,BorderLayout.CENTER);
		
		return pane;
		
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
