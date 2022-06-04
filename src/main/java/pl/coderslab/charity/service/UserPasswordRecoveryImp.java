package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.util.MessageTextUtil;
import pl.coderslab.charity.util.TokenUtil;

@AllArgsConstructor
@Service
public class UserPasswordRecoveryImp implements UserPasswordRecoveryService {
    private final EmailService emailService;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;

    @Override
    public void passwordRecover(User user){
        Token token = TokenUtil.generateToken(user);
        String message = MessageTextUtil.passRecoveryMessage(token.getToken());
        emailService.sendMessage(user, "Password recovery", message);
        tokenService.saveUserToken(token);
    }

    @Transactional
    @Override
    public void editPassword(User user) {
        Token token = tokenService.findByUser(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        tokenService.delete(token);
        userService.save(user);
    }
}
