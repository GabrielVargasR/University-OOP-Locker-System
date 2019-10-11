
package APIs;

import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;





/**
 *
 * @author gabriel
 */
public class ManejoCorreos {
    
    public ManejoCorreos(){}
    
    public void enviarCorreo(String pDestino){
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String emailAddress = "prograpoo123@gmail.com";
        String password = "lalairai_lalairala";
        
        Session session = Session.getInstance(properties,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(emailAddress, password);
	   }
         });
         
        try {
            // Crea mensaje
            MimeMessage message = new MimeMessage(session);
	
            // Agrega fuente
	    message.setFrom(new InternetAddress(emailAddress));
	
            // Agrega Destinatario
	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(pDestino));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("Rayforth1616@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("gabriel.vargasr99@gmail.com"));
            
	
	    // Subject del correo
	    message.setSubject("Prueba desde Java");
	
	    // Contenido del correo
	    message.setText("Email de prueba enviado desde java");
            
            // Envia correo
	    Transport.send(message);

            
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    
    
   public static void main(String[] args){
       ManejoCorreos a = new ManejoCorreos();
       a.enviarCorreo("josuearrietam99@gmail.com");
   }
}
