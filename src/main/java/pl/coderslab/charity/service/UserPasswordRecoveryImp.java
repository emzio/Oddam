package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.util.MessageTextUtil;
import pl.coderslab.charity.util.TokenUtil;

@AllArgsConstructor
@Service
public class UserPasswordRecoveryImp implements UserPasswordRecoveryService {
    private final EmailService emailService;
    private final TokenService tokenService;

    @Override
    public void passwordRecover(User user){
        Token token = TokenUtil.generateToken(user);
        String message = MessageTextUtil.passRecoveryMessage(token.getToken());
        emailService.sendMessage(user, "Password recovery", message);
        tokenService.saveUserToken(token);
    }
}
