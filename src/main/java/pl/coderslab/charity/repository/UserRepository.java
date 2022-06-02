package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findAllByRolesContainingAndEnabledIsTrue(Role role);

    long countAllByRolesContainingAndEnabledIsTrue(Role role);

    List<User> findAllByRolesNotContainingAndEnabledIsTrue(Role role);

    List<User> findAllByRolesNotContainingAndEnabledIsFalse(Role role);


    User findByEmail(String email);
}
