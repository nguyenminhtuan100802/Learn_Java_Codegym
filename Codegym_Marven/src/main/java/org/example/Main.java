package org.example;

//import java.net.Authenticator;
import java.util.Date;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {
    public static void main(String[] args) {
        // Replace with your Gmail email and app-specific password
//        String fromEmail = "nmtuanbank.email@gmail.com";
//        String password = "your-app-password";
        String fromEmail = "tuanminhnguyen100802@gmail.com"; // Your email
        String password = "ypyy qyef zciq cbxw";
        // Gmail SMTP server configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");  // TLS/STARTTLS port
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");  // For TLS

//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "465");  // SSL port
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.socketFactory.port", "465");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

// Add this line if still encountering TLS issues
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create an authenticator using your Gmail credentials
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        // Create the email session
        Session session = Session.getInstance(properties, authenticator);
//        session.setDebug(true);  // Enable debug for troubleshooting

        // Set the recipient and message details
        String toEmail = "nguyenminhtuan100802@gmail.com";
        MimeMessage message = new MimeMessage(session);

        try {
            message.addHeader("Content-type", "text/html; charset=UTF-8");
            message.setFrom(new InternetAddress(fromEmail));  // Use InternetAddress
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            message.setSubject("Hello World");
            message.setSentDate(new Date());
            message.setText("minh tuan ute 20119383 an com chua?", "UTF-8");

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}