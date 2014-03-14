package LibrarySystem;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginScreen extends JPanel {
	
	JTextField name = new JTextField(20);
	JTextField pass = new JTextField(20);
	JLabel lname = new JLabel("Name");
	JLabel lpass = new JLabel("Password");
	JLabel title = new JLabel("Login Page");

	
	public LoginScreen(){
		//this.setBackground(Color.magenta);
		//this.setLayout(new GridLayout(3,2));
		//this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		//this.add(title);
		//this.add(lpass);
		//this.add(pass);
		//this.add(lname);
		//this.add(name);
		//this.add(lname, BorderLayout.CENTER);
		//this.add(name);
		//this.add(lpass);
		//this.add(pass);
	
		//this.setSize(100, 100);
		this.setPreferredSize(new Dimension(300, 50));
	}
}
