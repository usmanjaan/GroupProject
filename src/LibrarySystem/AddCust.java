package LibrarySystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AddCust extends JDialog implements ActionListener {
    
    
    
    int len = 5;
    int textSize = 20;
    String[] fields = {"User ID", "User Name", "Password", "First Name", "Last Name"};
    JTextField[] texts = {new JTextField(textSize), 
        new JTextField(textSize), new JTextField(textSize), 
        new JTextField(textSize), new JTextField(textSize)};
    // used to access submitted values
    String[] results = {"null", "null", "null", "null", "null"};
    dbManager db = new dbManager();
    public AddCust() {
    	db.getConnection(); 
        // main dialog frame
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(7, 1));
        
        pan.add(new JLabel("Add New Customer"));
        
        for (int i = 0; i < len; i++) {
        	JPanel temp = new JPanel();
        	temp.add(new JLabel(fields[i]));
        	temp.add(texts[i]);
        	pan.add(temp);
        }
        
        // submit and cancel buttons
        JPanel buttons = new JPanel();
        
        JButton submit = new JButton("Submit");
        submit.addActionListener(this);
        buttons.add(submit);
        
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        buttons.add(cancel);
        
        pan.add(buttons);
        
        this.add(pan);
        //this.setSize(320, 480);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand() == "Submit") {
        	// will figure out how to put values directly in to database
            for (int i = 0; i < len; i++) {
            	results[i] = texts[i].getText();
            }
            //int active =Integer.valueOf(results[5]);
            db.addUser(results[0], results[1], results[2], results[3], results[4], 0);
            this.setVisible(false);
        } else if (ae.getActionCommand() == "Cancel") {
            this.setVisible(false);
        }
    }
    
}

