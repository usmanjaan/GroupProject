package LibrarySystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author robocop
 */
public class JavaApplication10 implements ActionListener {

    /**
     * @param args the command line arguments
     */
   
    
    public JavaApplication10() {
        JFrame Main = new JFrame();
        Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.setSize(640, 480);
        Main.setTitle("main window title");
        
        JPanel screen = new JPanel();
        
        JButton run = new JButton("add customer");
        run.addActionListener(this);
        screen.add(run);
        
        JButton bun = new JButton("add book");
        bun.addActionListener(this);
        screen.add(bun);
        
        Main.add(screen);
        
        Main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("" + ae.getActionCommand());
        if (ae.getActionCommand() == "add customer") {
        
            AddCust dialog = new AddCust();
            dialog.setVisible(true);
            //System.out.println("asdfadsfasdf");
            
        } else if (ae.getActionCommand() == "add book") {
        
            AddBook dialog = new AddBook();
            //System.out.println("asdfadsfasdf");
            
        }
    }
    
    public static void main(String[] args) {

         new JavaApplication10();
        
    }
}

