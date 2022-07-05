package pl.coderslab.charity.restResurces;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.UserRegister;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RestTestController {
    private final UserService userService;
    private final UserRegister userRegister;

    @GetMapping("rest/test")
    public String restTest(){
        return "rest/test";
    }

    @GetMapping("rest/user/edit")
    private String showUserEditForm(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        model.addAttribute("user", userService.findByUserName(currentUser.getUsername()));
        return "rest/editUserRest";
    }

    @PostMapping("rest/user/edit")
    private String proceedUserEditForm(@Valid User user, BindingResult result){

        if (userService.usernameRepetitionFound(user) || result.hasErrors()){
            return "rest/editUserRest";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("rest/register")
    private String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "/rest/register-rest";
    }

    @PostMapping("rest/register")
    private String proceedRegisterForm(@Valid User user, BindingResult result, @RequestParam String password2){
        if(result.hasErrors() || !userService.verifyPasswordRepetition(user.getPassword(), password2) || userService.usernameRepetitionFound(user)){
            return "/rest/register-rest";
        }
        userRegister.saveNotRegisteredUser(user);
        return "/register/register-mail-sent";
    }
}
