import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class VoterRegister extends JFrame {

    public VoterRegister() 
    {
        final JFrame frame = new JFrame();
        frame.setContentPane(new JLabel (new ImageIcon("bimagesmall.jpg")));
        JLabel t = new JLabel("EMAIL");
        t.setFont(new java.awt.Font("Helvetica",Font.BOLD,18));
        JLabel t2 = new JLabel("NAME");
        t2.setFont(new java.awt.Font("Helvetica",Font.BOLD,18));
        JLabel t3 = new JLabel("AGE");
        t3.setFont(new java.awt.Font("Helvetica",Font.BOLD,18));
        JLabel t4 = new JLabel("GENDER");
        t4.setFont(new java.awt.Font("Helvetica",Font.BOLD,18));
        final JTextField tf = new JTextField(15);
        final JTextField tf1 = new JTextField(15);
        final JTextField tf2 = new JTextField(15);
        final JTextField tf3 = new JTextField(15);
        final JTextField tf4 = new JTextField(15);
        JButton button = new JButton("SUBMIT");
        JButton button2 = new JButton("CANCEL");
        frame.setTitle("VOTER REGISTER");
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.add(t);
        frame.add(tf);
        frame.add(t2);
        frame.add(tf2);
        frame.add(t3);
        frame.add(tf3);
        frame.add(t4);
        frame.add(tf4);
        frame.add(button);
        frame.add(button2);
        frame.setVisible(true);
        try
        {
            if (Integer.parseInt(tf3.getText())<18)
            {
                JFrame frame2 = new JFrame("MESSAGE");
                JOptionPane.showMessageDialog(frame,"VOTER HAS TO BE ABOVE 18");
                frame2.setVisible(false);
            }
        }
        catch (Exception e)
        {
        }

        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    try 
                    {
                        if (Integer.parseInt(tf3.getText())>=18)
                        {
                            String f = "database.txt";
                            FileWriter fw = new FileWriter(f,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);
                            pw.println(tf.getText() + "*" + "password" + "*" + tf1.getText() + "*" + tf2.getText() + "*" + tf3.getText() + "*" + tf4.getText()+ "*");

                            String f2 = "statechange.txt";
                            FileWriter fw2 = new FileWriter(f2,true);
                            BufferedWriter bw2 = new BufferedWriter(fw2);
                            PrintWriter pw2 = new PrintWriter(bw2);
                            pw2.println(tf.getText() + "*" + " 0");

                            pw.close();
                            bw.close();
                            fw.close();
                            pw2.close();
                            bw2.close();
                            fw2.close();
                            JFrame frame = new JFrame("MESSAGE");
                            JOptionPane.showMessageDialog(frame,"VOTER HAS BEEN REGISTERED");
                            frame.setVisible(false);
                            Admin ad = new Admin();
                            ad.main();
                            frame.setVisible(false);
                        }
                        else
                        {
                            JFrame frame = new JFrame("MESSAGE");
                            JOptionPane.showMessageDialog(frame,"VOTER IS UNDER AGE");
                            frame.setVisible(false);
                        }

                    }
                    catch (IOException ee)
                    {
                    }
                }
            });    
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,4,2));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); 

        button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    try 
                    {
                        Admin ad = new Admin();
                        ad.main();
                        frame.setVisible(false);
                    }
                    catch (Exception ee)
                    {
                    }
                }
            }); 
    }

    public void run()
    {
        VoterRegister obj = new VoterRegister();
        obj.setVisible(true);
    }

}
