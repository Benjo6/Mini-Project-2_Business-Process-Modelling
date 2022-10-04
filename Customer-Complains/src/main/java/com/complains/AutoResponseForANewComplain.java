package com.complains;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import javax.inject.Named;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Named
public class AutoResponseForANewComplain implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("email");

        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.freesmtpservers.com");
        properties.put("mail.smtp.port","25");
        properties.put("mail.transport.protocol","smtp");
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress("AutoResponseMail@RandomMail.com"));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            message.setSubject("We have received your complain");

            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setText("Your complain has now be sent to the right department to solve your issue");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            //Send Message
            Transport.send(message);
        }
        catch (MessagingException messagingException){messagingException.printStackTrace();
        }
    }
}
