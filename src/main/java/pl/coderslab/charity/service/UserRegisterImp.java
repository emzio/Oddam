package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@RequiredArgsConstructor
@Service
public class UserRegisterImp implements UserRegister{

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Transactional
    @Override
    public void saveNotRegisteredUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setRegistered(false);
        user.setEnabled(false);
        userRepository.save(user);
        tokenService.saveForUser(user);
    }

    @Transactional
    @Override
    public void register(User user){
        Token tokenToDel = tokenService.findByUser(user);
        tokenService.delete(tokenToDel);
        user.setEnabled(true);
        user.setRegistered(true);
        userRepository.save(user);
    }

}
