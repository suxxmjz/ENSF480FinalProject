package controllers;

import java.time.LocalDateTime;
import java.util.*;
import javax.mail.*;

import javax.mail.internet.*;

public class EmailSystem {
	
	public static DatabaseController dbControl;
	public static int seatNumber;
	public static String email;
	Session newSession = null;
	
	public EmailSystem(DatabaseController dbControl, int seatNumber, String email) {
		EmailSystem.dbControl = dbControl;
		EmailSystem.seatNumber = seatNumber;
		EmailSystem.email = email;
	}
	
    public void sendMail(String email, double price, int seat, LocalDateTime time, String id, String theatre, int tNumber){
        String to = email.trim();
        String from = "ensf480movie@gmail.com";

        String Str;

        Str = "This is your ticket!\n"
        		+ "Ticket Number: " + tNumber + "\n"
        		+ "Theatre: " + theatre + "\n"
        		+ "Showroom: " + id + "\n"
        		+ "Seat Number: " + seat + "\n"
        		+ "Time: " + time + "\n"
        		+ "Amount: " + price;
        
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");


        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("ensf480movie@gmail.com", "stylquyurygqkdwx");
            }
        });

        try{

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Ticket Information");
            message.setText(Str);
            Transport.send(message);
        }
        catch(MessagingException mex){
            mex.printStackTrace();
        }

    }

}
