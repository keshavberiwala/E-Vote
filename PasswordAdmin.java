import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordAdmin
{

    private JFrame mainFrame;
    private JLabel statusLabel;

    public PasswordAdmin()
    {
        prepareGUI();
    }

    public static void main(String x)
    {
        PasswordAdmin  obj = new PasswordAdmin();      
        obj.enterPass(x);
    }

    private void prepareGUI()
    {
        mainFrame = new JFrame("ADMINISTRATOR LOGIN PAGE");
        mainFrame.setContentPane(new JLabel (new ImageIcon("bimage.jpg")));
        mainFrame.setSize(900,400);
        mainFrame.setVisible(true);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent windowEvent)
                {
                    System.exit(0);
                }        
            });    
              
        statusLabel = new JLabel("",JLabel.CENTER);    
        statusLabel.setSize(350,100);
        //mainFrame.add(mainFrame);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);  
    }

    private void enterPass(final String x)
    {
        JLabel  passwordLabel = new JLabel("Password: ", JLabel.CENTER);
        passwordLabel.setFont(new java.awt.Font("Helvetica",Font.BOLD,20));
        final JPasswordField passwordText = new JPasswordField(6);      
        passwordText.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        passwordText.setBackground(Color.YELLOW);
        passwordText.setForeground(Color.BLUE);
        passwordText.setToolTipText("Please enter the email password ");
        JButton loginButton = new JButton("Login");
        JButton button = new JButton("Back");
        loginButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {     
                    char[] pwd = passwordText.getPassword();
                    String password="";
                    for (int i =0;i<pwd.length;i++)
                        password+=pwd[i];
                    if (password.equals(x))
                        new Admin().main();
                    else
                    {
                        JFrame frame = new JFrame("MESSAGE");

                        // show a joptionpane dialog using showMessageDialog
                        JOptionPane.showMessageDialog(frame,
                            "WRONG PASSWORD");
                        frame.setVisible(false);
                    }

                }
            }); 

        mainFrame.add(passwordLabel);       
        mainFrame.add(passwordText);
        mainFrame.add(loginButton);
        mainFrame.add(button);
        mainFrame.setVisible(true); 
        button.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {     
                    new Voting().main();
                    mainFrame.setVisible(false);
                }
            });
    }
}
