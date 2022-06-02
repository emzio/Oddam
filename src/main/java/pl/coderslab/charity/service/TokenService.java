package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    void saveForUser(User user);

    Token findByToken(String token);

    Token findByUser(User user);
    void delete(Token tokenToDel);
}
