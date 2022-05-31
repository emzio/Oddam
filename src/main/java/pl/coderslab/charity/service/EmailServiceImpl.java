package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
//@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

//    private JavaMailSender emailSender;
//
//    @Autowired
//    public EmailServiceImpl(JavaMailSender emailSender) {
//        this.emailSender = emailSender;
//    }

    public void sendSimpleMessage(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendEmail(User user, String password) {

        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(user.getEmail());
            helper.setFrom("test@gmail.com");
            helper.setSubject("test");
            helper.setText("test ");

        } catch (MessagingException e){
            e.printStackTrace();
        }
        emailSender.send(message);
    }
}