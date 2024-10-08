package BankManagement.service;

import BankManagement.constant.TextColor;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailService {
    private static final String FROM_EMAIL = "tuanminhnguyen100802@gmail.com";
    private static final String PASSWORD = "ypyy qyef zciq cbxw";

    public static void sendEmailAccountCreated(String toEmail, String userName, String phoneNumber) {
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
        // Set the recipient and message details
        MimeMessage message = new MimeMessage(session);

        try {
            message.addHeader("Content-type", "text/html; charset=UTF-8");
            message.setFrom(new InternetAddress(FROM_EMAIL));  // Use InternetAddress
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            message.setSubject("TPBank - Thông báo tạo tài khoản thành công", "UTF-8");
            message.setSentDate(new Date());

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
                    "Quý khách <strong>" + userName + "</strong> (Số điện thoại: <strong>" + phoneNumber + "</strong>) đã được thực hiện thành công. <br> <br>" +
                    "Thông tin tài khoản như sau:" +
                    "</p>" +
                    "<ul>" +
                    "<li style=\"font-family: Arial, Helvetica, sans-serif\">Tên tài khoản: <strong>" + phoneNumber + "</strong></li>" +
                    "<li style=\"font-family: Arial, Helvetica, sans-serif\">Mật khẩu: <strong>" + phoneNumber + "</strong></li>" +
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
            System.out.println(TextColor.BLUE + "Email đã được gửi cho khách hàng!" + TextColor.END_COLOR);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void sendEmailResetPassword(String toEmail, String userFullName, String userName, String password){
        System.out.println(TextColor.YELLOW + "Mật khẩu khôi phục đang được gửi tới email bạn đăng ký" + TextColor.END_COLOR);
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
        MimeMessage message = new MimeMessage(session);

        try {
            message.addHeader("Content-type", "text/html; charset=UTF-8");
            message.setFrom(new InternetAddress(FROM_EMAIL));  // Use InternetAddress
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            message.setSubject("TPBank - Thông báo khôi phục mật khẩu đăng nhập", "UTF-8");
            message.setSentDate(new Date());

            String htmlContent = "<body>" +
                    "<div style=\"width: 40vw; height: fit-content; margin: 10px auto; overflow: auto; border: 0px solid black\">" +
                    "<a href=\"https://tpb.vn/ca-nhan\" target=\"_blank\">" +
                    "<img src=\"https://tpb.vn/wps/wcm/connect/f2a04181-b994-48fb-a786-86804ab2007b/1/web.JPEG?MOD=AJPERES&CVID=\" alt=\"\" style=\"width: 100%; height: 400px\">" +
                    "</a>" +
                    "<p style=\"text-align: center;color: purple; font-family: Arial, Helvetica, sans-serif; font-weight: bold\">THÔNG BÁO KHÔI PHỤC MẬT KHẨU</p>" +
                    "<div style=\"width: 100%\">" +
                    "<p style=\"width: 100%; font-family: Arial, Helvetica, sans-serif\">" +
                    "Kính gửi Quý khách "+ userFullName + " <br> <br>" +
                    "Ngân hàng Thương mại Cổ phần Tiên Phong (TPBank) trân trọng thông báo tài khoản của " +
                    "Quý khách đã được khôi phục thành công. <br> <br>" +
                    "Thông tin tài khoản như sau:" +
                    "</p>" +
                    "<ul>" +
                    "<li style=\"font-family: Arial, Helvetica, sans-serif\">Tên tài khoản: <strong>"+ userName +"</strong></li>" +
                    "<li style=\"font-family: Arial, Helvetica, sans-serif\">Mật khẩu: <strong>"+ password +"</strong></li>" +
                    "</ul>" +
                    "<p style=\"width: 100%; font-family: Arial, Helvetica, sans-serif\">" +
                    "Quý khách vui lòng truy cập tài khoản và thực hiện đổi mật khẩu để bảo mật thông tin cá nhân. <br> <br>" +
                    "TPBank xin chân thành cảm ơn Quý khách đã tin tưởng và sử dụng dịch vụ của chúng tôi." +
                    "Nếu có bất kỳ thắc mắc nào, vui lòng liên hệ với TPBank qua tổng đài chăm sóc khách hàng hoặc qua ứng dụng TPBank Mobile. <br> <br>" +
                    "Trân trọng!" +
                    "</p>" +
                    "</div>" +
                    "<p>" +
                    "<strong style=\"color: purple\">TPBank</strong> <br>" +
                    "Tầng 27, Tầng 28 và Tầng 29, toà nhà C5 D’Capitale, số 119 Đường Trần Duy Hưng, Phường Trung Hoà, Quận Cầu Giấy, Thành phố Hà Nội, Việt Nam. <br>" +
                    "Hotline: <span style=\"color: purple; cursor: pointer;\">1900 232 366</span>" +
                    "| Email: <span style=\"color: purple; cursor: pointer;\">cskh@tpb.com.vn</span>" +
                    "| Web: <span style=\"color: purple; cursor: pointer;\">www.tpb.com.vn</span> <br>" +
                    "</p>" +
                    "<hr>" +
                    "<p style=\"text-align: center\">" +
                    "<i> Đây là email được gửi tự động từ <strong style=\"color: purple\">TPBank</strong>, Quý khách vui lòng không trả lời email này." +
                    "Quý khách có thể truy cập vào hệ thống qua địa chỉ sau: <u style=\"color: #4954d0; cursor: pointer;\">https://www.tpb.com.vn/tci3-home</u>" +
                    "hoặc tải ứng dụng TPBank tại <u style=\"color: #4954d0; cursor: pointer;\">http://qrco.de/AppTPBank</u>.</i>" +
                    "</p>" +
                    "</div>" +
                    "</body>";

            message.setContent(htmlContent,  "text/html; charset=UTF-8");

            // Send the message
            Transport.send(message);
            System.out.println(TextColor.BLUE + "Email đã được gửi cho khách hàng!" + TextColor.END_COLOR);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
