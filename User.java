import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class User {

    public static void main (){    
        JFrame frame = new JFrame("USER WINDOW");
        frame.setContentPane(new JLabel (new ImageIcon("bimage.jpg")));
        frame.setVisible(true);
        frame.setSize(900,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton button1 = new JButton("LOG IN TO VOTE");
        c.gridx=45;
        c.gridy=1;
        frame.add(button1,c);
        button1.setForeground(Color.BLUE);
        button1.setFont(new java.awt.Font("Algerian", Font.BOLD, 14));
        button1.addActionListener (new Action1());
        JButton button2 = new JButton("CANDIDATE INFORMATION");
        c.gridx=45;
        c.gridy=100;
        frame.add(button2,c);
        button2.setForeground(Color.BLUE);
        button2.setFont(new java.awt.Font("Algerian", Font.BOLD, 14));
        button2.addActionListener (new Action2()); 
        JButton button3 = new JButton("BACK");
        c.gridx=45;
        c.gridy=1000;
        frame.add(button3,c);
        button3.setForeground(Color.BLUE);
        button3.setFont(new java.awt.Font("Algerian", Font.BOLD, 14));
        button3.addActionListener (new Action3());
    }
    static class Action1 implements ActionListener 
    {        
        public void actionPerformed (ActionEvent e) 
        {      
            login ln = new login();
            ln.run();
        }
    }   
    static class Action2 implements ActionListener 
    {        
        public void actionPerformed (ActionEvent e) 
        {     
            SeeInfo si= new SeeInfo();
            si.main();
        }
    }
    static class Action3 implements ActionListener 
    {        
        public void actionPerformed (ActionEvent e) 
        {     
            new Voting().main();
        }
    }  

}
