package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;

public interface EmailService {

    void sendToken(User user, Token token);

    void sendSimpleMessage(
            String to, String subject, String text);

    void sendMessage(User user, String subject, String messageText);

    void sendEmail(User user, String password);

}

