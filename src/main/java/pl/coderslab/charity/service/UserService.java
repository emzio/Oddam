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

    List<String> findRolesNames(CurrentUser customUser);

    List<User> findAllAdmins();

    Optional<User> findById(Long id);

    void deleteAdmin(User userToCompare, User user);

    List<User> findAllEnabledUsers();

    List<User> findAllDisabledUsers();

    void disableUser(User user);

    void deleteUser(User user);

    void changePassword(User user);

    Optional<User> findByEmail(String email);

    boolean emailRepetitionFound(User user);

    boolean usernameRepetitionFound(User user);

    boolean dataRepetitionFound(User user);

}