
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
public class Result {

    public static void main() 
    {
        final JFrame frame = new JFrame("RESULT TABLE");
        try
        {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String[] columns = {"Serial Number","Name", "Number of votes"};
            String f1 = "vote.txt";
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String str=br.readLine();
            int count=0;
            while(str!=null )
            {

                if(str.length()>0)
                    count++;

                str = br.readLine();
            }
            Object data[][] = new Object[count][3]; 
            String f2 = "vote.txt";
            FileReader fr2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(fr2);

            str=br2.readLine();
            int i =0,p=0;
            String array[] = new String[count];
            String res="";
            String temp="",n2="";
            int max=0,c=0,n=0;
            while(str!=null)
            {
                if(str.length()>0)
                {
                    array[i++] = str;
                }
                str = br2.readLine();
            } 

            for (int x=0;x<count;x++)
            {
                data[x][0] = x+1;
                StringTokenizer st = new StringTokenizer(array[x],"*");
                c=0;
                for (int y=1;y<3;y++)
                {
                    if (c==0)
                    {
                        temp = st.nextToken();
                        data[x][y] = temp;
                        c=1;
                    }
                    else if (c==1) 
                    {
                        n2 = st.nextToken();
                        data[x][y] = n2;
                        n=Integer.parseInt(n2.trim());
                        if (n>max)
                        {
                            max = n;
                            res = temp;
                        }
                    }
                }
            }
            String s1=res.substring(0,res.indexOf('('));
            String s2=res.substring(res.indexOf('(')+1,res.length()-1);
            JFrame frame2 = new JFrame("WINNER");
            JOptionPane.showMessageDialog(frame2, "THE WINNER IS " + s1.toUpperCase() + " FROM PARTY " + s2 + " WITH " + max + " VOTES! ");
            frame2.setVisible(false);
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);

            JLabel lblHeading = new JLabel("                                                            RESULT PAGE                        ");
            lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));

            frame.getContentPane().setLayout(new BorderLayout());

            frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
            frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
            table.setSize(200,200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 1000);
            frame.setVisible(true);
            fr.close();
            fr2.close();
            br.close();
            br2.close();
            JPanel panel = new JPanel();
            frame.add(panel);
            JButton button1 = new JButton("CLOSE");
            panel.add(button1,BorderLayout.CENTER);
            frame.setLayout(new GridLayout(3,1));
            button1.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) 
                    {
                        frame.setVisible(false);
                        new Admin().main();
                    }
                }); 
        }
        catch (Exception e)
        {
        }

    }
}

