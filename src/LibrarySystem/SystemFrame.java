package LibrarySystem;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SystemFrame extends JFrame {
	
	LoginScreen scrn = new LoginScreen();
	JLabel txt = new JLabel("Text");
	JPanel pane = new JPanel();
	JPanel pane1 = new JPanel();
	
	public SystemFrame(){
		this.setSize(500, 500);
		this.setLocation(300, 300);
		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(scrn);
		//this.add(txt);
	}
	
	public void showFrame(){
		this.setVisible(true);
	}
	
	public void hideFrame(){
		this.setVisible(false);
	}

}
