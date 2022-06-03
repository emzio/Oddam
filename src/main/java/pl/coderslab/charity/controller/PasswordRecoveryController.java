package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.EmailService;
import pl.coderslab.charity.service.TokenService;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.util.MessageTextUtil;
import pl.coderslab.charity.util.TokenUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class PasswordRecoveryController {

    private final UserService userService;
    private final TokenService tokenService;
    private final EmailService emailService;

    @GetMapping("/password-recovery")
    public String showPasswordRecoveryForm(){
        return "password-recovery";
    }

    @PostMapping("/password-recovery")
    @ResponseBody
    public String processPasswordRecoveryForm(@RequestParam String email, HttpServletRequest request){
        User user = userService.findByEmail(email);
        if(user!=null){
            Token token = TokenUtil.generateToken(user);
            String message = MessageTextUtil.passRecoveryMessage(request.getRequestURL().toString(), token.getToken());
            emailService.sendMessage(user, "Password recovery",message);
            tokenService.saveForUser(user);
            return "sentEmail";
        }
        return "error";
    }
}
