package BankManagement.management;

import BankManagement.utility.TextColor.TextColor;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailManagement {
    private static final String FROM_EMAIL = "tuanminhnguyen100802@gmail.com";
    private static final String PASSWORD = "ypyy qyef zciq cbxw";

    public static void announceAccountCreatedSuccessfully(String toEmail, String bodyMail){
        System.out.println(TextColor.YELLOW + "Đang gửi email thông báo đến khách hàng..." + TextColor.END_COLOR);
        // Gmail SMTP server configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");  // TLS/STARTTLS port
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");  // For TLS

        // Add this line if still encountering TLS issues
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create an authenticator using your Gmail credentials
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        };

        // Create the email session
        Session session = Session.getInstance(properties, authenticator);
        //        session.setDebug(true);  // Enable debug for troubleshooting

        // Set the recipient and message details
        //        String toEmail = "nguyenminhtuan100802@gmail.com";
//        String toEmail = "20119383@student.hcmute.edu.vn";
        MimeMessage message = new MimeMessage(session);

        try {
            message.addHeader("Content-type", "text/html; charset=UTF-8");
            message.setFrom(new InternetAddress(FROM_EMAIL));  // Use InternetAddress
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            message.setSubject("TPBank - Thông báo tạo tài khoản thành công");
            message.setSentDate(new Date());
//            message.setText(bodyMail, "UTF-8");
            String htmlContent = " <h1>Welcome to <a href=\"gpcoder.com\">GP Coder</a></h1> " +
            "<img src=\"https://gpcoder.com/wp-content/uploads/2017/10/Facebook_Icon_GP_2-300x180.png\" " + " width=\"300\" " + " height=\"180\" " + " border=\"0\" " + " alt=\"gpcoder.com\" />";
            message.setContent(htmlContent, "text/html");

            // Send the message
            Transport.send(message);
            System.out.println(TextColor.BLUE + "Email đã được gửi cho khách hàng!" + TextColor.END_COLOR);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
