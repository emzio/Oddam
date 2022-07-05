package pl.coderslab.charity.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.repository.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder, TokenService tokenService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tokenService = tokenService;
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRegistered(true);
        Role userRole = roleRepository.findByName("ROLE_USER");
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole, adminRole)));
        userRepository.save(user);
    }

    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public boolean verifyPasswordRepetition(String password, String passwordRep){
        return password.equals(passwordRep);
    }

    @Override
    public List<String> findRolesNames(CurrentUser customUser){
        return customUser.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();
    }

    @Override
    public List<User> findAllAdmins(){
        Role role = roleRepository.findByName("ROLE_ADMIN");
        return userRepository.findAllByRolesContainingAndEnabledIsTrue(role);
    }

    @Override
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public void deleteAdmin(User userToCompare, User user){
        if(!userToCompare.getId().equals(user.getId())){
            Role roleAdmin = roleRepository.findByName("ROLE_ADMIN");
            user.getRoles().remove(roleAdmin);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> findAllEnabledUsers(){
        Role role = roleRepository.findByName("ROLE_ADMIN");
        return userRepository.findAllByRolesNotContainingAndEnabledIsTrue(role);
    }

    @Override
    public List<User> findAllDisabledUsers(){
        Role role = roleRepository.findByName("ROLE_ADMIN");
        return userRepository.findAllByRolesNotContainingAndEnabledIsFalse(role);
    }

    @Override
    public void disableUser(User user){
        user.setEnabled(false);
        userRepository.save(user);
    }

    @Override
    public void changePassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void deleteUser(User user){
        user.setEnabled(false);
        user.setRegistered(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUsername(passwordEncoder.encode(user.getUsername()));
        user.setName(passwordEncoder.encode(user.getName()));
        user.setLastname(passwordEncoder.encode(user.getLastname()));
        user.setPhone(passwordEncoder.encode(user.getPhone()));
        userRepository.save(user);
    }



    @Override
    public boolean usernameRepetitionFound(User user){
        User savedUser = userRepository.findByUsername(user.getUsername());
        if(savedUser!=null){
            return !savedUser.getId().equals(user.getId());
        }
        return false;
    }

}
