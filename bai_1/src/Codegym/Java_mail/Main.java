package Codegym.Java_mail;

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
        System.out.println("Email is sending...");
        String fromEmail = "tuanminhnguyen100802@gmail.com"; // Your email
        String password = "ypyy qyef zciq cbxw";

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
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        // Create the email session
        Session session = Session.getInstance(properties, authenticator);
//        session.setDebug(true);  // Enable debug for troubleshooting

        // Set the recipient and message details
//        String toEmail = "nguyenminhtuan100802@gmail.com";
        String toEmail = "nguyenminhtuan100802@gmail.com";
        MimeMessage message = new MimeMessage(session);

        try {
            message.addHeader("Content-type", "text/html; charset=UTF-8");
            message.setFrom(new InternetAddress(fromEmail));  // Use InternetAddress
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            message.setSubject("Hello World", "UTF-8");
            message.setSentDate(new Date());
//            message.setText("minh tuan ute 20119383 an com chua?", "UTF-8");
//            String htmlContent = " <h1>Welcome to <a href=\"gpcoder.com\">GP Coder</a></h1> " +
//                    "<img src=\"https://gpcoder.com/wp-content/uploads/2017/10/Facebook_Icon_GP_2-300x180.png\" " + " width=\"300\" " + " height=\"180\" " + " border=\"0\" " + " alt=\"gpcoder.com\" />";

            String htmlContent = "<body>" +
                    "<div style=\"width: 40vw; height: fit-content; margin: 10px auto; overflow: auto; border: 0px solid black\">" +
                    "<a href=\"https://tpb.vn/ca-nhan\" target=\"_blank\">" +
                    "<img src=\"https://tintuc.ngan-hang.com/media/blog/1635382688044.png\" " +
                    "alt=\"\" style=\"width: 100%; height: 400px\">" +
                    "</a>" +
                    "<div style=\"width: 100%\">" +
                    "<p style=\"width: 100%; font-family: Arial, Helvetica, sans-serif\">" +
                    "Kính gửi Quý khách hàng, <br> <br>" +
                    "Ngân hàng Thương mại Cổ phần Tiên Phong (TPBank) trân trọng thông báo thông tin mở tài khoản của " +
                    "Quý khách <strong>Nguyễn Minh Tuấn</strong> (Số điện thoại: <strong>0123456789</strong>) đã được thực hiện thành công. <br> <br>" +
                    "Thông tin tài khoản như sau:" +
                    "</p>" +
                    "<ul>" +
                    "<li style=\"font-family: Arial, Helvetica, sans-serif\">Tên tài khoản: <strong>0123456789</strong></li>" +
                    "<li style=\"font-family: Arial, Helvetica, sans-serif\">Mật khẩu: <strong>0123456789</strong></li>" +
                    "</ul>" +
                    "<p style=\"width: 100%; font-family: Arial, Helvetica, sans-serif\">" +
                    "Quý khách vui lòng truy cập tài khoản và thực hiện đổi mật khẩu để bảo mật thông tin cá nhân. <br> <br>" +
                    "TPBank xin chân thành cảm ơn Quý khách đã tin tưởng và sử dụng dịch vụ của chúng tôi. " +
                    "Nếu có bất kỳ thắc mắc nào, vui lòng liên hệ với TPBank qua tổng đài chăm sóc khách hàng hoặc qua ứng dụng TPBank Mobile. <br> <br>" +
                    "Trân trọng!" +
                    "</p>" +
                    "</div>" +
                    "<a href=\"https://tpb.vn/ca-nhan\" target=\"_blank\">" +
                    "<img src=\"https://trantanduy.com/wp-content/uploads/2022/06/dang-ky-tpbank-nhan-tien-mien-phi.jpg\" " +
                    "alt=\"alternatetext\" style=\"width: 100%\">" +
                    "</a>" +
                    "<p>" +
                    "<strong style=\"color: purple\">TPBank</strong> <br>" +
                    "Tầng 27, Tầng 28 và Tầng 29, toà nhà C5 D’Capitale, số 119 Đường Trần Duy Hưng, Phường Trung Hoà, Quận Cầu Giấy, Thành phố Hà Nội, Việt Nam. <br>" +
                    "Hotline: <span style=\"color: purple; cursor: pointer;\">1900 232 366</span> " +
                    "| Email: <span style=\"color: purple; cursor: pointer;\">cskh@tpb.com.vn</span> " +
                    "| Web: <span style=\"color: purple; cursor: pointer;\">www.tpb.com.vn</span> <br>" +
                    "</p>" +
                    "<hr>" +
                    "<p style=\"text-align: center\">" +
                    "<i> Đây là email được gửi tự động từ <strong style=\"color: purple\">TPBank</strong>, Quý khách vui lòng không trả lời email này. " +
                    "Quý khách có thể truy cập vào hệ thống qua địa chỉ sau: <u style=\"color: #4954d0; cursor: pointer;\">https://www.tpb.com.vn/tci3-home</u> " +
                    "hoặc tải ứng dụng TPBank tại <u style=\"color: #4954d0; cursor: pointer;\">http://qrco.de/AppTPBank</u>.</i>" +
                    "</p>" +
                    "</div>" +
                    "</body>";



            message.setContent(htmlContent,  "text/html; charset=UTF-8");
            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}