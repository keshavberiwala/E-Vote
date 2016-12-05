import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Password
{

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    //private JPanel mainFrame;

    public Password()
    {
        prepareGUI();
    }

    public static void main(String x, String y)
    {
        Password  obj = new Password();      
        obj.enterPass(x,y);
    }

    private void prepareGUI()
    {
        mainFrame = new JFrame("PASSWORD PAGE");
        mainFrame.setContentPane(new JLabel (new ImageIcon("bimage.jpg")));
        mainFrame.setSize(900,400);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent windowEvent)
                {
                    System.exit(0);
                }        
            });    
        headerLabel = new JLabel("", JLabel.CENTER);        
        statusLabel = new JLabel("",JLabel.CENTER);    
        statusLabel.setSize(350,100);
        mainFrame.add(headerLabel);
        mainFrame.add(new JLabel());
        mainFrame.add(new JLabel());
        mainFrame.add(new JLabel());
        mainFrame.add(statusLabel);
        mainFrame.add(new JLabel());
        mainFrame.setVisible(true);  
    }

    private void enterPass(final String x,final String y)
    {
        headerLabel.setText("Email id : " + x); 
        headerLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        JLabel  passwordLabel = new JLabel("Password: ", JLabel.CENTER);
        passwordLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        final JPasswordField passwordText = new JPasswordField(6);      
        passwordText.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        passwordText.setBackground(Color.YELLOW);
        passwordText.setForeground(Color.BLUE);
        passwordText.setToolTipText("Provided password contains 3 upper case alphabets, 3 lower case alphabets and 2 digits.");
        JButton loginButton = new JButton("Login");
        loginButton.setForeground(Color.BLUE);
        JButton button = new JButton("Log out");
        button.setForeground(Color.BLUE);
        loginButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {     
                    char[] pwd = passwordText.getPassword();
                    String password="";
                    for (int i =0;i<pwd.length;i++)
                        password+=pwd[i];
                    if (password.equals(y))
                        new Vote(x);
                    else
                    {
                        JFrame frame = new JFrame("ERROR!");
                        JOptionPane.showMessageDialog(frame, "Wrong Password!");
                        frame.setVisible(false);
                    }

                }
            }); 
        button.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {     
                    new login().run();
                    mainFrame.setVisible(false);
                }
            }); 

        mainFrame.add(passwordLabel);       
        mainFrame.add(passwordText);
        mainFrame.add(loginButton);
        mainFrame.add(button);
        mainFrame.setVisible(true);  
    }
}
