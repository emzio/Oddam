package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

@Controller
@AllArgsConstructor
public class PasswordRecoveryController {

    private final UserService userService;

    @GetMapping("/password-recovery")
    public String showPasswordRecoveryForm(){
        return "password-recovery";
    }

    @PostMapping("/password-recovery")
    @ResponseBody
    public String processPasswordRecoveryForm(@RequestParam String email){
        User user = userService.findByEmail(email);
        if(user!=null){
            user.setEnabled(true);
            return "sentEmail";
        }
        return "notFounded";
    }
}
