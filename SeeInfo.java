
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
public class SeeInfo {

    public static void main() 
    {
        final JFrame frame = new JFrame("CANDIDATE TABLE");
        try
        {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String[] columns = {"Serial Number", "Name", "Party", "Gender","Age"};
            String f1 = "database2.txt";
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
            Object data[][] = new Object[count][5]; 
            String f2 = "database2.txt";
            FileReader fr2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(fr2);

            str=br2.readLine();
            int i =0,p=0;
            String array[] = new String[count];
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
                for (int y=1;y<5;y++)

                    data[x][y]= st.nextToken();
            }
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);

            JLabel lblHeading = new JLabel("                                              CANDIDATE INFORMATION                        ");
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
                        new User().main();
                    }
                }); 
        }
        catch (Exception e)
        {
        }

    }
}

