package classes;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
/**
 * Created by IBM on 20/03/2017.
 */
public class emailsend {
    private  static final String username = "yahyaking9@gmail.com";
    private static final String password = "#left?wing10#";
    private static Message message = null;
    public static String receiver;

    public  static  String subject;
    public static  String emailtxt;

    public static void settextforsmeinitial(User n, String date, int time) throws MessagingException {
        subject="You have a new Appplicant to be Interview ";
        emailtxt="App is scheduled on "+date+" and on Time "+time +" Kindly login into the system to accept or reject the applicant for interview ";

        receiver=n.getUserEmail();

    }

    public static void settextforsmeconfirm(AppHrTable a){

        receiver=a.getEmail();
        subject="You have a Interview at our office at "+a.getDateHrm()+" Time :" +a.getTimeHrm();
        emailtxt="Dear \n"+a.appName
                +"\nYou Interview for the job: "+a.getAppCv()+"\n"+"has been scheduled with a Subject Matter Expert. Kindly visit on the time scheduled for the interviewe ";


    }

    public static void settextforhrmconfirm(AppHrTable a){

        receiver=a.getEmail();
        subject="You have a Interview at our office at "+a.getDateHrm()+" Time :" +a.getTimeHrm();
        emailtxt="Dear \n"+a.appName
                +"\nYou Interview for the job: "+a.getAppCv()+"\n"+"has been scheduled with a HRM. Kindly visit on the time scheduled for the interview ";


    }

    public static void attachaccept() throws MessagingException {

        BodyPart messageBodyPart = new MimeBodyPart();

        // Now set the actual message
        messageBodyPart.setText("You Have been Hired for the job. Kindly See the attached details ");

        // Create a multipar message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);
        String filename = "/cvfiles/doc.txt";
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        message.setContent(multipart);


    }


    public  static void sendmail(){


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");



        Session session = Session.getInstance(props,new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        try
        {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver));
            message.setSubject(subject);
            message.setContent(emailtxt, "text/html; charset=utf-8");
            Transport.send(message);
            System.out.println("Email Sent");
        } catch (MessagingException e)
        {
            throw new RuntimeException(e);
        }




    }



}
