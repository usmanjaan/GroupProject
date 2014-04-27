package LibrarySystem;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class dailog extends JDialog{
	JLabel testLabel = new JLabel();
	public dailog(int row, int column)
	{
		setSize(200,200);
        setLayout(new FlowLayout());
        testLabel.setText("User double clicked at row "+row+" and column "+ column);
        setVisible(true);
        add(testLabel);

	}
}
