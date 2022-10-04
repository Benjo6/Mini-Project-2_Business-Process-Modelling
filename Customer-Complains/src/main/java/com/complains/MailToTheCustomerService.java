package com.complains;

import jdk.jfr.Name;
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
public class MailToTheCustomerService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String name = (String) delegateExecution.getVariable("name");
        String email = (String) delegateExecution.getVariable("email");
        String body = (String) delegateExecution.getVariable("body");
        String formtype = (String) delegateExecution.getVariable("formtype");

        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.freesmtpservers.com");
        properties.put("mail.smtp.port","25");
        properties.put("mail.transport.protocol","smtp");
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress("AutoResponseMail@RandomMail.com"));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress("CustomerService@RandomMail.com"));

            message.setSubject("A new issue is reported ["+formtype+"]");

            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setText(name+" "+email+" "+body);

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
