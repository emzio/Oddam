package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findAllByRolesContainingAndEnabledIsTrue(Role role);

    List<User> findAllByRolesNotContainingAndEnabledIsTrue(Role role);

    List<User> findAllByRolesNotContainingAndEnabledIsFalse(Role role);


    Optional<User> findByEmail(String email);

    @Query("SELECT u.email FROM User u where u.email = ?1")
    String findEmail(String email);

    @Query("SELECT u.username FROM User u WHERE u.username = ?1")
    String findUserName(String username);
}
