package controller;

import entity.OTP;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class SendMail {

    public static void sendMail(String emailTo) {

        try {
            final String fromEmail = "blueStreamFPT@gmail.com";
            // Mat khai email cua ban
            final String password = "mcxoqqhntjoaqyrk";
            // dia chi email nguoi nhan
            final String toEmail = emailTo;

            final String subject = "Thank you for donating";

            final String body = ""
                    + "<body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">"
                    + "    <!--100% body table-->"
                    + "    <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\""
                    + "        style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">"
                    + "        <tr>"
                    + "            <td>"
                    + "                <table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\""
                    + "                    align=\"center\" cellpadding=\"0\" cellspacing=\"0\">"
                    + "                    <tr>"
                    + "                        <td style=\"height:40px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"text-align:center;\">"
                    + "                            <a href=\"/\" title=\"logo\" target=\"_blank\">"
                    + "                                <img width=\"100\" src=\"https://w7.pngwing.com/pngs/38/204/png-transparent-computer-icons-check-mark-true-or-false-miscellaneous-company-logo.png\" title=\"logo\" alt=\"logo\">"
                    + "                            </a>"
                    + "                        </td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"height:20px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td>"
                    + "                            <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\""
                    + "                                style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">"
                    + "                                <tr>"
                    + "                                    <td style=\"height:40px;\">&nbsp;</td>"
                    + "                                </tr>"
                    + "                                <tr>"
                    + "                                    <td style=\"padding:0 35px;\">"
                    + "                                        <h1"
                    + "                                            style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">"
                    + "                                            You have"
                    + "                                            donated successfully</h1>"
                    + "                                        <span"
                    + "                                            style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>"
                    + "                                        <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">"
                    + "                                            We received your donate to BlueStream "
                    + "                                            You are wonderfull. Thank for being part of us."
                    + "                                        </p>"
                    + "                                    </td>"
                    + "                                </tr>"
                    + "                                <tr>"
                    + "                                    <td style=\"height:40px;\">&nbsp;</td>"
                    + "                                </tr>"
                    + "                            </table>"
                    + "                        </td>"
                    + "                    <tr>"
                    + "                        <td style=\"height:20px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"height:80px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                </table>"
                    + "            </td>"
                    + "        </tr>"
                    + "    </table>"
                    + "    <!--/100% body table-->"
                    + "</body>";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            MimeMessage msg = new MimeMessage(session);

            msg.setSubject(subject, "UTF-8");

            msg.setContent(body, "text/html");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
            System.out.println("Gui mail thanh cong");
        } catch (Exception e) {
            System.out.println("Gui mail that bai.");
        }
    }

    public static void sendMailOTP(String emailTo, String otp) {
        

        try {
            final String fromEmail = "blueStreamFPT@gmail.com";
            // Mat khai email cua ban
            final String password = "mcxoqqhntjoaqyrk";
            // dia chi email nguoi nhan
            final String toEmail = emailTo;

            final String subject = "SEND OTP";

            
            String otpContent = "<a href=\"javascript:void(0);\""
                        + "         style=\"background:#20e277;text-decoration:none !important; font-weight:500; margin-top:35px; color:#fff;text-transform:uppercase; font-size:23px;padding:10px 24px;display:inline-block;border-radius:50px;\">"
                        + "         " + otp + "</a>";
            
            String statusIcon = "https://w7.pngwing.com/pngs/38/204/png-transparent-computer-icons-check-mark-true-or-false-miscellaneous-company-logo.png";
           
            String mailContent = "Please do not share with anyone.";
            
            String mailDetail = "Your OTP code is:";
            
            final String body = ""
                    + "<body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">"
                    + "    <!--100% body table-->"
                    + "    <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\""
                    + "        style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">"
                    + "        <tr>"
                    + "            <td>"
                    + "                <table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\""
                    + "                    align=\"center\" cellpadding=\"0\" cellspacing=\"0\">"
                    + "                    <tr>"
                    + "                        <td style=\"height:40px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"text-align:center;\">"
                    + "                            <a href=\"/\" title=\"logo\" target=\"_blank\">"
                    + "                                <img width=\"100\" src=\"" + statusIcon + "\" title=\"logo\" alt=\"logo\">"
                    + "                            </a>"
                    + "                        </td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"height:20px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td>"
                    + "                            <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\""
                    + "                                style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">"
                    + "                                <tr>"
                    + "                                    <td style=\"height:40px;\">&nbsp;</td>"
                    + "                                </tr>"
                    + "                                <tr>"
                    + "                                    <td style=\"padding:0 35px;\">"
                    + "                                        <h1"
                    + "                                            style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">"
                    + "                                            " + mailContent + "</h1>"
                    + "                                        <span"
                    + "                                            style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>"
                    + "                                        <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">"
                    + mailDetail
                    + "                                        </p>"
                    + otpContent
                    + "                                    </td>"
                    + "                                </tr>"
                    + "                                <tr>"
                    + "                                    <td style=\"height:40px;\">&nbsp;</td>"
                    + "                                </tr>"
                    + "                            </table>"
                    + "                        </td>"
                    + "                    <tr>"
                    + "                        <td style=\"height:20px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"text-align:center;\">"
                    + "                            <p"
                    + "                                style=\"font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;\">"
                    + "                                &copy; <strong>blueStream</strong></p>"
                    + "                        </td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"height:80px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                </table>"
                    + "            </td>"
                    + "        </tr>"
                    + "    </table>"
                    + "    <!--/100% body table-->"
                    + "</body>";
            
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            MimeMessage msg = new MimeMessage(session);

            msg.setSubject(subject, "UTF-8");

            msg.setContent(body, "text/html");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
            System.out.println("Gui mail thanh cong");
        } catch (Exception e) {
            System.out.println("Gui mail that bai.");
        }
    }

    public static void main(String[] args) {
        OTP otp = new OTP();
        String otpCode = otp.getOTP();
        sendMailOTP("ngominhcuong202@gmail.com", otpCode );
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input.equals(otpCode));

//        sendMail("ngominhcuong202@gmail.com");
    }
}
