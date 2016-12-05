import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin {

    public static void main (){    
        JFrame frame = new JFrame("ADMINISTRATOR WINDOW");
        frame.setContentPane(new JLabel (new ImageIcon("bimage.jpg")));
        frame.setSize(900,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        JButton button1 = new JButton("REGISTER A VOTER");
      
        frame.add(button1);
        button1.setForeground(Color.RED);
        button1.setFont(new java.awt.Font("Times", Font.BOLD, 14));
        button1.addActionListener (new Action1());
        JButton button2 = new JButton("REGISTER A CANDIDATE");
        frame.add(button2);
        button2.setForeground(Color.RED);
        button2.setFont(new java.awt.Font("Times", Font.BOLD, 14));
        button2.addActionListener (new Action2()); 
        JButton button3 = new JButton("RESULTS");
        frame.add(button3);
        button3.setForeground(Color.RED);
        button3.setFont(new java.awt.Font("Times", Font.BOLD, 14));
        button3.addActionListener (new Action3()); 
        JButton button4 = new JButton("LOG OUT");
        frame.add(button4);
        button4.setForeground(Color.RED);
        button4.setFont(new java.awt.Font("Times", Font.BOLD, 14));
        button4.addActionListener (new Action4()); 
    }
    static class Action1 implements ActionListener 
    {        
        public void actionPerformed (ActionEvent e) 
        {     
            VoterRegister vr = new VoterRegister();
        }
    }   
    static class Action2 implements ActionListener 
    {        
        public void actionPerformed (ActionEvent e) 
        {     
            CandidateRegister cr = new CandidateRegister();
        }
    }
    static class Action3 implements ActionListener 
    {        
        public void actionPerformed (ActionEvent e) 
        {       
            new Result().main();

        }
    }  
    static class Action4 implements ActionListener 
    {        
        public void actionPerformed (ActionEvent e) 
        {   
            new Voting().main();

        }
    } 
}
