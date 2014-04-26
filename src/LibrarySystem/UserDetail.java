package LibrarySystem;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserDetail extends JFrame {

	/**
	 * @param args
	 */
	ImageIcon image;
	JButton edit,delete,remove;
	JLabel id,name,address,course,bloan,limage;
	JTable loan;
	
	public UserDetail()
	{
		setSize(350,250);
		setLayout(new GridLayout(2,0));
		add(top());
		add(loanbook());
		
	}
	
	public JPanel top()
	{
		JPanel t = new JPanel();
		t.setLayout(new BoxLayout(t,BoxLayout.Y_AXIS));
		image = new ImageIcon();
		limage = new JLabel(image);
		id = new JLabel("c08335478");
		name= new JLabel("usman shahid");
		address= new JLabel("5-liffey road");
		course= new JLabel("DT228/3");
		
		t.add(limage);
		t.add(id);
		t.add(name);
		t.add(address);
		t.add(course);
		
		return t;
		
	}
	
	
	public JTable loanbook()
	{
		String[] columnNames = { "title","author","isbn","copies","image"		
		};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
		        };
		
		JTable table = new JTable(data,columnNames);
		//table.setPreferredScrollableViewportSize(new Dimension(300, 70));
        //table.setFillsViewportHeight(true);
        //JScrollPane scrollPane = new JScrollPane(table);
        //add(scrollPane);


		return table;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetail ud = new UserDetail();
		ud.setVisible(true);
	}

}
