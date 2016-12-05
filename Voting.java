import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Voting {

    public static void main (){    
        JFrame frame = new JFrame("MAIN WINDOW");
        frame.setContentPane(new JLabel (new ImageIcon("bimage.jpg")));
        frame.setSize(900,400);
        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        JButton button1 = new JButton("ADMIN");
        c.gridx=45;
        c.gridy=1;
        frame.add(button1,c);
        button1.setForeground(Color.BLUE);
        button1.addActionListener (new Action1());
        JButton button2 = new JButton("USER");
        c.gridx=45;
        c.gridy=10;
        button2.setForeground(Color.BLUE);
        JButton button3 = new JButton("EXIT");
        button3.setForeground(Color.BLUE);
        frame.add(button2,c);
        c.gridx=45;
        c.gridy=100;
        frame.add(button3,c);
        c.anchor = GridBagConstraints.PAGE_END;
        button3.addActionListener (new Action3());
        button2.addActionListener (new Action2()); 
    }
    static class Action1 implements ActionListener
    {        
        public void actionPerformed (ActionEvent e) 
        {     PasswordAdmin o = new PasswordAdmin();
            o.main("evoteadmin12");    
        }
    }   
    static class Action2 implements ActionListener 
    {        
        public void actionPerformed (ActionEvent e) 
        {     
            new User().main();
        }
    }   
    static class Action3 implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            System.exit(0);
        }
    }

}
