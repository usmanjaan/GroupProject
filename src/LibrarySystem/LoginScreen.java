package LibrarySystem;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginScreen extends JFrame {
	
	
	private JButton exit,login;
	public JTextField user,password;
	private JLabel luser,lpassword;
	
	//welcome w = new welcome();
	

		public LoginScreen()
		{
			Container contentPane = getContentPane();
			getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
			contentPane.setLayout(null);
	        setLocationRelativeTo(null);
		  	setVisible(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("login");					//setting the title of panel
			setSize(350,250);							//setting the size of panel
			setResizable(false);
			
				luser = new JLabel("UserName:");
				luser.setBounds(30, 30, 75, 25);
				
				user = new JTextField(10);
							//side down, size
				user.setBounds(100,30,150,25);
				user.setToolTipText("plase enter the username");
				
				lpassword = new JLabel("Password:");
				lpassword.setBounds(30,80,75,25);
													
				
				password = new JPasswordField(10);
				password.setToolTipText("plase enter the password");
				password.setBounds(100, 80, 150, 25);
				
				
				exit = new JButton("Exit");
				exit.setBounds(270,150,60,40);
				exit.addActionListener(new buttonActionListener());
				
			
				login = new JButton("Login");
				login.setBounds(200,150,65,40);
				login.addActionListener(new buttonActionListener());
				
				
                add(luser);
                add(user);
                add(lpassword);
                add(password);
                add(exit);
                add(login);
				setVisible(true);
		}
			
			

			private class buttonActionListener implements ActionListener
				{

					public void actionPerformed(ActionEvent e)
					{
						if(e.getSource() == login)
						{
							
							String us = user.getText();
							String pass = password.getText();
						dbManager db= new dbManager();
						String storedpass = null;
						try {
							storedpass = db.getPassword(us);
							if(!pass.equals(storedpass))
							{
								JOptionPane.showMessageDialog(null,"Login Unsuccessful! try again");
								
							}
							else if(pass.equals(storedpass))
							{
								JOptionPane.showMessageDialog(null,"Login successful!");
								setVisible(false);
								SearchScreen s = new SearchScreen();
								s.setVisible(true);
							}		
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
				
						}
						if(e.getSource()== exit)
						{
							System.exit(0);
						}
					}
				}


			public static void main(String arg[])
			{
				 new LoginScreen();
				 

			}
}