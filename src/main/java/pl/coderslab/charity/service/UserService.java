package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);

    public void saveAdmin(User user);

    boolean verifyPasswordRepetition(String password, String passwordRep);

    Role findRole(CurrentUser customUser);
}