import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class login extends JFrame {

    public login() 
    {
        final JFrame frame = new JFrame();
        frame.setContentPane(new JLabel (new ImageIcon("bimage.jpg")));
        JLabel t = new JLabel("EMAIL");
        t.setFont(new java.awt.Font("Times",Font.BOLD,16));
        JPasswordField p = new JPasswordField(10);
        final JTextField tf = new JTextField(15);
        frame.setTitle("LOGIN PAGE");
        JButton button = new JButton("SUBMIT");
        button.setForeground(Color.BLUE);
        JButton button2 = new JButton("CANCEL");
        button2.setForeground(Color.BLUE);
        JLabel statuslabel = new JLabel();
        statuslabel.setText("Password will be sent to your email account if it is registered");
        statuslabel.setFont(new java.awt.Font("Times",Font.BOLD,16));
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.add(t);
        frame.add(tf);
        frame.add(button);
        frame.add(button2);
        frame.add(statuslabel);
        final String pwd = otp();
        button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    try
                    {

                        final String email =tf.getText();
                        // final String pwd=otp();
                        String f1 = "database.txt";
                        FileReader fr1 = new FileReader(f1);
                        BufferedReader br1 = new BufferedReader(fr1);
                        String str1=br1.readLine();
                        boolean flag = false,flag2=false;
                        while(str1!=null )
                        {
                            if (str1.length()>0)
                            {
                                int p = str1.indexOf("*");
                                String id = "";

                                id = str1.substring(0,p);
                                if (id.equals(email))
                                    flag=true;
                            }
                            str1=br1.readLine();    
                        }

                        if (flag==true)
                        {
                            String f2 = "statechange.txt";
                            FileReader fr2 = new FileReader(f2);
                            BufferedReader br2 = new BufferedReader(fr2);
                            String str=br2.readLine();
                            while (str!=null)
                            {
                                if (str.endsWith("* 0") && str.startsWith(email))
                                {
                                    flag2=true;
                                }
                                str=br2.readLine();
                            }

                            if (flag2==true)
                            {
                                sendEmail b = new sendEmail();
                                String subject="e-Vote : One Time Password";
                                String body = "Dear User, \n\nThank you for using e-Vote. \n\nYour one time password(OTP) is : " + pwd;
                                b.sendEmail("vote.evote@gmail.com",tf.getText(),subject,body);
                                Password psw = new Password();
                                psw.main(email,pwd);
                                frame.setVisible(false);
                            }
                            else 
                            {
                                JFrame frame = new JFrame("MESSAGE");

                                // show a joptionpane dialog using showMessageDialog
                                JOptionPane.showMessageDialog(frame,
                                    "SORRY! YOU HAVE ALREADY VOTED");
                                frame.setVisible(false);
                            }
                        }
                        else 
                        {

                            JFrame frame2 = new JFrame("ERROR!");
                            JOptionPane.showMessageDialog(frame2, "Given email id is not registered!");
                            frame2.setVisible(false);
                        }
                    }

                    catch (IOException ev)
                    {
                    }
                }
            });  

        button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    try 
                    {
                        new User().main();
                        frame.setVisible(false);
                        //dispose();
                    }
                    catch (Exception ee)
                    {
                    }
                }
            }); 

        frame.setLayout(new FlowLayout(FlowLayout.CENTER,4,2));

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        frame.setVisible(true);
    }

    public void run()
    {
        login obj = new login ();

    }

    String otp()
    {
        char ch=' ';
        int res=0;
        String s="";
        for (int i = 1;i<=3;i++)
        {
            res = (int)((Math.random()*(90-65)) + 65);
            ch = (char)res;
            s+=ch;
        }

        for (int i = 1;i<=3;i++)
        {
            res = (int)((Math.random()*(122-97) + 97));
            ch = (char)res;
            s+=ch;
        }
        for (int i = 1;i<=2;i++)
        {
            res = (int)((Math.random()*9));
            s+=res;
        }
        return s;
    }

}
