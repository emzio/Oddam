package pl.coderslab.charity.restResurces;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RestTestController {
    private final UserService userService;

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

        if (userService.emailRepetitionFound(user) || result.hasErrors()){
            return "user/edit";
        }
        userService.save(user);
        return "redirect:/";
    }
}
