import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
// the appropriate libraries, as mentioned above have to be imported //
class sendEmail
{

    public void sendEmail (String from, String to, String subject, String body)
    {
        //uses javax.mail package functions//
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getInstance(props,new javax.mail.Authenticator() 
                {

                    protected PasswordAuthentication getPasswordAuthentication() 
                    {

                        return new PasswordAuthentication("vote.evote@gmail.com" ,"evoteadmin12");

                    }

                });
        
        try
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vote.evote@gmail.com"));//change accordingly
            message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            Voting obj = new Voting();
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Error has occurred. Check logger.txt for details.");
        }
    }

}
