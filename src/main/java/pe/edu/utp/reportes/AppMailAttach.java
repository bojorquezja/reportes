package pe.edu.utp.reportes;


import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.Properties;

public class AppMailAttach {
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

            BodyPart msgBodyPart = new MimeBodyPart();
            String msg = "Es el primer correo usando JavaMailer y attachment";
            msgBodyPart.setContent(msg, "text/html; charset=utf-8");

            BodyPart archBodyPart = new MimeBodyPart();
            String arch = a.class.getClassLoader().getResource("MandaEmail.pdf").toURI().getPath();
            DataSource source = new FileDataSource(arch);
            archBodyPart.setDataHandler(new DataHandler(source));
            archBodyPart.setFileName(arch);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(msgBodyPart);
            multipart.addBodyPart(archBodyPart);
            message.setContent(multipart);

            Transport.send(message);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
