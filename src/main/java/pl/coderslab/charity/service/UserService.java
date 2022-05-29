package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import java.util.List;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);

    public void saveAdmin(User user);

    boolean verifyPasswordRepetition(String password, String passwordRep);

    Role findRole(CurrentUser customUser);

    List<User> findAllAdmins();

    User findById(Long id);

    void deleteAdmin(User user);

    long count();
}