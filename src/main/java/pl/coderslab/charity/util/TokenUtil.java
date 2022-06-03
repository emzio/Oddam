package pl.coderslab.charity.util;

import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;

import java.util.UUID;

public class TokenUtil {

    public static Token generateToken (User user){
        Token token = new Token();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        return token;
    }
}
