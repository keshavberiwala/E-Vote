import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class CandidateRegister extends JFrame {

    public CandidateRegister() 
    {

        final JFrame f = new JFrame();
        f.setContentPane(new JLabel (new ImageIcon("bimagesmall.jpg")));
        //  f.setLayout(new GridLayout());
        JLabel t = new JLabel("NAME");
        t.setFont(new java.awt.Font("Helvetica",Font.BOLD,18));
        JLabel t2 = new JLabel("PARTY");
        t2.setFont(new java.awt.Font("Helvetica",Font.BOLD,18));
        JLabel t3 = new JLabel("GENDER");
        t3.setFont(new java.awt.Font("Helvetica",Font.BOLD,18));
        JLabel t4 = new JLabel("AGE");
        t4.setFont(new java.awt.Font("Helvetica",Font.BOLD,18));
        final JTextField tf = new JTextField(15);
        final JTextField tf1 = new JTextField(15);
        final JTextField tf2 = new JTextField(15);
        final JTextField tf3 = new JTextField(15);
        final JTextField tf4 = new JTextField(15);
        JButton button = new JButton("ENTER");
        JButton button2 = new JButton("CANCEL");
        f.setTitle("CANDIDATE");
        f.setSize(200, 370);
        f.setLocationRelativeTo(null);
        f.add(t);
        f.add(tf);
        f.add(t2);
        f.add(tf2);
        f.add(t3);
        f.add(tf3);
        f.add(t4);
        f.add(tf4);
        f.add(button);
        f.add(button2);
        button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) 
                {
                    try 
                    {
                        String f = "database2.txt";
                        FileWriter fw = new FileWriter(f,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
                        pw.println(tf.getText() + "*" + tf1.getText() + "*" + tf2.getText() + "*" + tf3.getText() + "*" + tf4.getText()+ "*" );

                        String f2 = "vote.txt";
                        FileWriter fw2 = new FileWriter(f2,true);
                        BufferedWriter bw2 = new BufferedWriter(fw2);
                        PrintWriter pw2 = new PrintWriter(bw2);
                        pw2.print("\n" + tf.getText() + "(" + tf2.getText() + ")" + " * " + "0");

                        pw.close();
                        bw.close();
                        fw.close();
                        pw2.close();
                        bw2.close();
                        pw2.close();

                        setVisible(false);
                        Admin ad = new Admin();
                        ad.main();
                    }
                    catch (IOException ee)
                    {
                    }
                }
            }); 

        button2.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) 
                {
                    f.setVisible(false);
                    new Admin().main();
                }
            });

        f.setLayout(new FlowLayout(FlowLayout.CENTER,4,2));
        f.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        f.setVisible(true);

    }

    public void run()
    {
        CandidateRegister obj = new CandidateRegister();
        obj.setVisible(true);
    }

}
