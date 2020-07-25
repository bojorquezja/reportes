package pe.edu.utp.reportes;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AppMail {
    public static void main(String[] args) {
        final String username = "micorreo@gmail.com";
        final String password = "micontrasena";
        
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("desde@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("destinatario1@gmail.com, destinatario2@gmail.com")
            );
            message.setSubject("Prueba Gmail TLS");
            message.setText("Hola AMigo,"
                    + "\n\n Ojala llegue el mail!");

            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
