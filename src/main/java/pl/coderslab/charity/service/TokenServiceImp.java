package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.TokenRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TokenServiceImp implements TokenService{
    private final TokenRepository tokenRepository;

    private final EmailService emailService;

    @Override
    public void saveForUser(User user) {
        Token token = new Token();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        String url = "http://localhost:8080/register/uuid/"+ token.getToken();
        String text = "<a href='"+url+"'>"+url+"</a>";
        emailService.sendToken(user, token);
        tokenRepository.save(token);
    }

    @Override
    public void saveUserToken(Token token){
        tokenRepository.save(token);
    }

    @Override
    public Token findByToken(String token){
        return tokenRepository.findByToken(token);
    }

    @Override
    public Token findByUser(User user){
        return tokenRepository.findByUser(user);
    }

    @Override
    public void delete(Token tokenToDel){
        tokenRepository.delete(tokenToDel);
    }
}
