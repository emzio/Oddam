package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

public interface UserRegister {

    void saveNotRegisteredUser(User user);

    void register(User user);
}
