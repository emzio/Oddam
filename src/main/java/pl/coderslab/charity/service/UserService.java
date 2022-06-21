package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);

    void saveAdmin(User user);

    void save(User user);

    boolean verifyPasswordRepetition(String password, String passwordRep);

    String findRole(CurrentUser customUser);

    List<User> findAllAdmins();

    User findById(Long id);

    void deleteAdmin(User userToCompare, User user);

    long count();

    List<User> findAllEnabledUsers();

    List<User> findAllDisabledUsers();

    void disableUser(User user);

    void deleteUser(User user);

    void changePassword(User user);

    void saveNotRegisteredUser(User user);

    void register(User user);

    User findByEmail(String email);

    boolean emailRepetitionFound(User user, Optional<User> optionalSavedUser);

    boolean usernameRepetitionFound(User user,Optional<User> optionalSavedUser);

    boolean dataRepetitionFound(User user);
}