package LibrarySystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AddBook extends JDialog implements ActionListener {
    
    public static void main(String[] args) {
        new AddBook();
    }
    
    int len = 4;
    int textSize = 20;
    String[] fields = {"Title", "ISBN", "Author", "Image"};
    JTextField[] texts = {new JTextField(textSize), 
        new JTextField(textSize), 
        new JTextField(textSize), 
        new JTextField(textSize)};
    // used to access submitted values
    String[] results = {"null", "null", "null", "null"};
    
    public AddBook() {
        
        // main dialog frame
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(6, 1));
        // dialog title
        pan.add(new JLabel("Add New Book"));
        
        /**
         * adding label and textfield to a temporary panel
         * which is put in to the grid layout of the main panel
         * done to look more like a form
         */
        for (int i = 0; i < len; i++) {
        	JPanel temp = new JPanel();
        	temp.add(new JLabel(fields[i]));
        	temp.add(texts[i]);
        	pan.add(temp);
        }
        
        // buttons for submit and cancel
        JPanel buttons = new JPanel();
        
        JButton submit = new JButton("Submit");
        submit.addActionListener(this);
        buttons.add(submit);
        
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        buttons.add(cancel);
        
        pan.add(buttons);
        
        // add main panel to dialog
        this.add(pan);
        //this.setSize(320, 480);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        if (ae.getActionCommand() == "Submit") {
        
        	// will figure out how to put values directly in to database
            for (int i = 0; i < len; i++) {
            	results[i] = texts[i].getText();
            }
            this.setVisible(false);
            
        } else if (ae.getActionCommand() == "Cancel") {
        
            this.setVisible(false);
            
        }
        
    }
    
}

