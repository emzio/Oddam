package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(HttpServletRequest request, HttpServletResponse response, Model model){
        Cookie passRep = WebUtils.getCookie(request, "verifyPasswordRep");
        if(passRep!=null){
            model.addAttribute("passRep", "Hasła nie są takie same!");
            passRep.setMaxAge(0);
            response.addCookie(passRep);
        }
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String proceedRegisterForm(User user, HttpServletResponse response, @RequestParam String password2){
        if(userService.verifyPasswordRepetition(user.getPassword(), password2)){
            userService.saveUser(user);
            return "redirect:/login";
        }
        Cookie cookie = new Cookie("verifyPasswordRep", "false");
        cookie.setPath("/register");
        response.addCookie(cookie);
        return "redirect:/register";
    }

    @GetMapping("/user/edit")
    private String showUserEditForm(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        User user = userService.findByUserName(currentUser.getUsername());
        model.addAttribute("user", user);
        return "user/edit";
    }

//    @GetMapping("/user/edit/{userName}")
//    private String showUserEditForm(@PathVariable String userName, Model model){
//        User user = userService.findByUserName(userName);
//        model.addAttribute("user", user);
//        return "user/edit";
//    }

    @PostMapping("/user/edit")
    private String proceedUserEditForm(User user){
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/user/password/edit")
    private String showUserPasswordEditForm(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        User user = userService.findByUserName(currentUser.getUsername());
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

   // TESTOWE TESTOWE TESTOWE TESTOWE TESTOWE TESTOWE TESTOWE TESTOWE TESTOWE TESTOWE

    @GetMapping("/create-user")
    @ResponseBody
    public String createAdmin() {
        User user = new User();
        user.setUsername("user1");
        user.setPassword("user1");
        userService.saveUser(user);
        return "user";
    }

    @GetMapping("/create-admin")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin3");
        user.setPassword("admin3");
        userService.saveAdmin(user);
        return "admin";
    }

    @GetMapping("/introduce")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }
}
