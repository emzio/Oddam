package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

@Controller
public class AdminsController {

    private final UserService userService;

    public AdminsController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("admin/list")
    private String showAllAdmins(Model model){
        model.addAttribute("admins", userService.findAllAdmins());
        return "admin/list";
    }

    @GetMapping("admin/delete/{id}")
    private String showDeleteForm(@PathVariable Long id, Model model){
        model.addAttribute("admin", userService.findById(id));
        return "admin/delete";
    }

    @PostMapping("admin/delete/{id}")
    private String proceedDeleteForm(User user){
        userService.deleteAdmin(user);
        return "redirect:/admin/list";
    }

    @GetMapping("admin/add")
    private String showAddForm(Model model){
        model.addAttribute("admin", new User());
        return "admin/add";
    }

    @PostMapping("admin/add")
    private String proceedAddForm(User user, @RequestParam String passwordRep){
        if(userService.verifyPasswordRepetition(user.getPassword(),passwordRep)){
            userService.saveAdmin(user);
            return "redirect:/admin/list";
        }
        return "redirect:/admin/add";
    }

    @GetMapping("admin/edit/{id}")
    private String showEditForm(@PathVariable Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("admin", user);
        return "admin/edit";
    }

    @PostMapping("admin/edit/{id}")
    private String proceedAddForm(User user){
        userService.save(user);
        return "redirect:/admin/list";
    }


    @GetMapping("/admin/users")
    private String showAllUsers(Model model){
        model.addAttribute("enabledUsers", userService.findAllEnabledUsers());
        model.addAttribute("disabledUsers", userService.findAllDisabledUsers());
        return "/admin/users";
    }

    @GetMapping("admin/user/edit/{id}")
    private String showUserEditForm(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "admin/user-edit";
    }

    @PostMapping("admin/user/edit/{id}")
    private String proceedUserEditForm(User user){
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("admin/user/delete/{id}")
    private String showUserDeleteForm(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "admin/user-delete";
    }

    @GetMapping("admin/user/disable/{id}")
    private String disableUser(@PathVariable Long id){
        User user = userService.findById(id);
        userService.disableUser(user);
        return "redirect:/admin/users";
    }
    @PostMapping("admin/user/delete/{id}")
    private String proceedUserDeleteForm(User user){
        userService.deleteUser(user);
        return "redirect:/admin/users";
    }
}
