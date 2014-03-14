package LibrarySystem;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class welcome {
	public JFrame f = new JFrame();
	public JPanel p;
	public JLabel welcome;
	
	public welcome()
	{
		frame();
	}

	private void frame() {
		// TODO Auto-generated method stub
		f.setLocation(200,200);
		f.setSize(300, 300);
		
		p = new JPanel();
		welcome = new JLabel();
		welcome.setText("welcome to welcomepage");
		p.add(welcome);
		f.add(p);
		f.setVisible(true);
		
		
		
	}

	
	

}
