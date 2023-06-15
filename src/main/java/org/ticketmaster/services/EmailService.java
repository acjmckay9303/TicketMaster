package org.ticketmaster.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.ticketmaster.models.EventDTO;



@Service
public class EmailService {
    
    private final JavaMailSender emailSender;
    
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    
    @SneakyThrows
    public void sendEventNotification(EventDTO event) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo("acjmckay@outlook.com"); // Set the recipient here
        helper.setFrom("eventnotification@ticketmaster.com");
        helper.setSubject("New Event Released: " + event.getName());
        
        String htmlMsg = "<h3>New Event Released!</h3>" +
                             "<p><b>Name: </b>" + event.getName() + "</p>" +
                             "<p><b>URL: </b><a href='" + event.getUrl() + "'>Click here</a></p>" +
                             "<p><b>Locale: </b>" + event.getLocale() + "</p>";
        
        helper.setText(htmlMsg, true); // Set the second parameter to 'true' for HTML content
        
        emailSender.send(mimeMessage);
    }
}
