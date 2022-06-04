package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

//    @Autowired

    private final JavaMailSender emailSender;


//    private JavaMailSender emailSender;
//
//    @Autowired
//    public EmailServiceImpl(JavaMailSender emailSender) {
//        this.emailSender = emailSender;
//    }

//    public void sendSimpleMessage(String to, String subject, String text){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("noreply@baeldung.com");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        emailSender.send(message);
//    }

    @Override
    public void sendSimpleMessage(String to, String subject, String text)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendMessage(User user, String subject, String messageText)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject(subject);
        message.setText(messageText);
        emailSender.send(message);
    }

    @Override
    public void sendToken(User user, Token token)
    {
        //        pageContext.request.contextPath

        String url = "http://localhost:8080/register/uuid/"+ token.getToken();
//        String text = "<a href='"+url+"'>"+url+"</a>";
        String text = url;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject(" Rejestracja - Oddam w dobre ręce \n ");
        message.setText(" Dziękujemy za rejestrację \n "
                + " Aby aktywować konto kliknij w link: \n "
        + text);
        emailSender.send(message);
    }

    @Override
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