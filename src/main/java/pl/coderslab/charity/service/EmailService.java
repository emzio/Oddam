package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

public interface EmailService {

    void sendSimpleMessage(
            String to, String subject, String text);

    void sendEmail(User user, String password);

}

