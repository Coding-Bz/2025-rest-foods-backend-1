package ch.noseryoung.REST_Foods.domain.MailAdmin;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;



public class JavaMailUtil {

public static void sendMail(String recepient, String name, LocalDate date, int partySize, LocalTime time) throws Exception {
    System.out.printf("Preparing mail to %s\n", recepient);
    Properties properties = new Properties();
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

    String myAccountEmail = "ortnermontag@gmail.com";
    String myPassword = "dwln gxnr ahij tpuj";

    javax.mail.Session session = javax.mail.Session.getInstance(properties, new Authenticator() {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("fortnermontag@gmail.com","dwln gxnr ahij tpuj");

        }
    });

    Message message = prepareMessage(session,myAccountEmail,recepient,name,date,partySize,time);
    Transport.send(message);
    System.out.printf("Success!! Sent message to %s\n", recepient);
}

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String name, LocalDate date, int partySize, LocalTime time) {


        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Reservation Confirmation");
            message.setText("Hi there "+name+"\n"
            +"Your reservation is in "+date +" "+time+"\n" +"PartySize: "+partySize+" \n" +"At delays we are not obligated to reserve your table any longer");

            return message;
        }catch (Exception ex){
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }}