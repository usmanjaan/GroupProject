package LibrarySystem;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SystemFrame extends JFrame {
	
	LoginScreen scrn = new LoginScreen();
	JLabel txt = new JLabel("Text");
	
	public SystemFrame(){
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(scrn, BorderLayout.NORTH);
		this.add(txt);
	}
	
	public void showFrame(){
		this.setVisible(true);
	}
	
	public void hideFrame(){
		this.setVisible(false);
	}

}
