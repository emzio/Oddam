package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;

public interface TokenService {
    void saveForUser(User user);

    Token findByToken(String token);
}
