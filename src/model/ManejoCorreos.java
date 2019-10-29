
package model;

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
 * @author Gabriel
 */
public class ManejoCorreos {
    private static ManejoCorreos singleton;
    private String correo;
    private String password;
    private Properties properties;
    
    private ManejoCorreos(){
        this.correo = "prograpoo123@gmail.com";
        this.password = "lalairai_lalairala";
        this.properties =  new Properties();
        this.properties.put("mail.smtp.auth", "true");
        this.properties.put("mail.smtp.starttls.enable", "true");
        this.properties.put("mail.smtp.host", "smtp.gmail.com");
        this.properties.put("mail.smtp.port", "587");
    }
    
    /**
     * Función para conseguir instancia de la clase (singleton)
     * @return instancia única de la clase
     */
    public static ManejoCorreos getInstance(){
        if (singleton == null){
            singleton = new ManejoCorreos();
        }
        return singleton;
    }
    
    /**
     * Función para enviar un correo
     * @param pDestino dirección de correo destino
     * @param pSubject subject del correo a enviar
     * @param pTexto texto del correo
     * @return boolean indicando si se pudo enviar o no el correo
     */
    public boolean enviarCorreo(String pDestino, String pSubject, String pTexto){
        
        Session session = Session.getInstance(this.properties,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(correo, password);
	   }
         });
         
        try {
            // Crea mensaje
            MimeMessage message = new MimeMessage(session);
	
            // Agrega fuente
	    message.setFrom(new InternetAddress(correo));
	
            // Agrega Destinatario
	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(pDestino));
	
	    // Subject del correo
	    message.setSubject(pSubject);
	
	    // Contenido del correo
	    message.setText(pTexto);
            
            // Envia correo
	    Transport.send(message);

            
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
