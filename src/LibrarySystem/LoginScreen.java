package LibrarySystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginScreen extends JPanel {
	
	JTextField name = new JTextField(20);
	JTextField pass = new JTextField(20);
	JLabel lname = new JLabel("Name");
	JLabel lpass = new JLabel("Password");
	
	public LoginScreen(){
		this.setBackground(Color.magenta);
		this.setLayout(new GridLayout(4,4));
		this.add(lname);
		this.add(name);
		this.add(lpass);
		this.add(pass);
	
		//this.setSize(100, 100);
		this.setPreferredSize(new Dimension(50, 100));
	}
}
