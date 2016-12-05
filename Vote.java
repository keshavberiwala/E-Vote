import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JRadioButton.*;
import java.awt.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.*;
public class Vote extends JFrame 
{
    static Button b;
    public Vote(final String x) 
    {
        try
        {
            final JFrame f = new JFrame();
            f.setTitle("VOTING  PAGE");
            f.setContentPane(new JLabel (new ImageIcon("bimage.jpg")));
            f.setSize(900, 400);
            f.setLocationRelativeTo(null);
            Container content= getContentPane();
            content.setLayout(new BorderLayout());
            JPanel[]panel;
            int count=0,count2=0;
            String f1 = "database2.txt";
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String str=br.readLine();

            while(str!=null )
            {

                if(str.length()>0)
                    count++;

                str = br.readLine();
            }

            String f2 = "database2.txt";
            FileReader fr2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(fr2);
            String arr[] = new String[count];
            str=br2.readLine();

            int i =0,p=0;

            while(str!=null)
            {
                if(str.length()>0)
                {
                    StringTokenizer st = new StringTokenizer(str,"*");
                    arr[i++] = st.nextToken() + "(" + st.nextToken() + ")";
                }
                str = br2.readLine();
            } 

            JRadioButton jrb[] = new JRadioButton[arr.length];
            final ButtonGroup group = new ButtonGroup();

            class VoteItemListener implements ItemListener {

                public void itemStateChanged(ItemEvent ev)
                {
                    try
                    {
                        boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
                        AbstractButton button = (AbstractButton) ev.getItemSelectable();
                        String file = "vote.txt";
                        FileReader fr4 = new FileReader(file);
                        BufferedReader br4 = new BufferedReader(fr4);
                        String str="";
                        String test=br4.readLine();
                        String y="";
                        boolean flag=false;

                        int selectedOption = JOptionPane.showConfirmDialog(null, "Do you want to vote for " + button.getActionCommand()  + "?", 
                                "Choose", JOptionPane.YES_NO_OPTION); 
                        if (selectedOption == JOptionPane.YES_OPTION) 
                        {
                            flag=true;
                            JFrame frame2 = new JFrame("MESSAGE");

                            JOptionPane.showMessageDialog(frame2,"CONGRATULATIONS. YOU HAVE VOTED FOR " + button.getActionCommand() + "!!");
                            frame2.setVisible(false);
                        }
                        else
                        {

                            f.setVisible(false);
                        }

                        if (flag==true)
                        {
                            while(test!=null)
                            {
                                //  System.out.println(test);
                                StringTokenizer s = new StringTokenizer (test,"*");
                                if (test.length()>0)
                                {
                                    y = s.nextToken().trim();
                                    //System.out.println(y + " " + button.getActionCommand() + " " + y.equals(button.getActionCommand()) );
                                    if (y.equals(button.getActionCommand().trim()))
                                    { 

                                        //System.out.println("COUNT");
                                        str+=button.getActionCommand()+ " * ";
                                        String x = s.nextToken().trim();
                                        int num = Integer.parseInt(x);
                                        num++;
                                        str+=num+ "\n";
                                    }
                                    else
                                    {
                                        str+=y+ "*" + s.nextToken()+"\n";
                                    }
                                }
                                test=br4.readLine();
                            }
                            FileWriter fw = new FileWriter(file,false);
                            BufferedWriter bw = new BufferedWriter (fw);
                            PrintWriter pw = new PrintWriter(bw);
                            pw.println(str);

                            final String file2="statechange.txt";
                            String f3 = "statechange.txt";
                            FileReader fr3 = new FileReader(f3);
                            BufferedReader br3 = new BufferedReader(fr3);
                            String test2=br3.readLine();
                            String str3="";
                            while(test2!=null)
                            {
                                StringTokenizer st = new StringTokenizer(test2,"*");

                                if (test2.length()>0)

                                {
                                    String temp = st.nextToken().trim();
                                    if (temp.equals(x))
                                    { 

                                        str3+= temp + " * ";
                                        String x2 = st.nextToken().trim();

                                        int num = Integer.parseInt(x2);
                                        num++;
                                        str3+= num + "\n";

                                    }
                                    else
                                    {
                                        //  System.out.println("FALSE " + temp);
                                        str3+= temp+ "*" + st.nextToken()+"\n";
                                    }
                                }
                                test2=br3.readLine();
                            }   
                            FileWriter fw2 = new FileWriter(file2,false);
                            BufferedWriter bw2 = new BufferedWriter (fw2);
                            PrintWriter pw2 = new PrintWriter(bw2);
                            pw2.println(str3);

                            pw.close();
                            bw.close();
                            fw.close();
                            br4.close();
                            fr4.close();

                            pw2.close();
                            bw2.close();
                            fw2.close();
                            br3.close();
                            fr3.close();
                            f.setVisible(false);
                        }
                        User o = new User();
                        o.main();                    
                    }
                    catch (IOException e)
                    {
                    }

                }
            }
            ItemListener il = new VoteItemListener();
            for(i =0;i<arr.length;i++)
            {
                jrb[i] = new JRadioButton(arr[i]);
                f.add(jrb[i]);
                group.add(jrb[i]);
                jrb[i].setFont(new java.awt.Font("Helvetica", Font.BOLD, 14));
                jrb[i].addItemListener(il);
            }
            //JLabel statusLabel = new JLabel("Once you select a candidate and then choose 'NO' in the next option pane, you will have to log in again.",JLabel.CENTER); 
            //statusLabel.setFont(new java.awt.Font("Helvetica",Font.ITALIC,14));
            f.setLayout(new GridLayout(4,1));
            f.add(new JLabel());
            f.add(new JLabel());
            f.add(new JLabel());
            f.add(new JLabel());
            //f.add(statusLabel);
            f.setVisible(true);
            br.close();
            br2.close();
            fr.close();
            fr2.close();
            f.setVisible(true);
        }
        catch (Exception e)
        {
        }

    }

    class Action1 implements ActionListener 
    {        
        public void actionPerformed (ActionEvent e) 
        {
            setVisible(false);
            User o = new User();
            o.main();
        }
    }

}
