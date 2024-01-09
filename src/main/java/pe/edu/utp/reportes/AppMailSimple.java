package pe.edu.utp.reportes;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class AppMailSimple {
    public static void main(String[] args) {
        //crear mail en mailtrap
        final String username = "postmaster@sandboxf4eb7b48318b4b4b955013929e9c2724.mailgun.org";
        final String password = "734424ec1850eb409aaaf2465acdf801-7ecaf6b5-ddae52dd";
        
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailgun.org");
        prop.put("mail.smtp.port", "587");
        //prop.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("anyname@freelance.mailtrap.link"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("bojorquez.ja@gmail.com")
            );
            message.setSubject("Prueba Gmail TLS");

            String msg = "Es el primer correo usando JavaMailer";
            message.setText(msg);

            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
