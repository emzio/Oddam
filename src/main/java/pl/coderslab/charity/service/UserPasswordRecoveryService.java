package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

public interface UserPasswordRecoveryService {

    void passwordRecover(User user);

    void editPassword(User user);
}
