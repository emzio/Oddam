package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("admin/admin/delete/{id}")
    private String showDeleteForm(@PathVariable Long id, Model model){
        model.addAttribute("admin", userService.findById(id));
        return "admin/delete";
    }

    @PostMapping("admin/admin/delete/{id}")
    private String proceedDeleteForm(User user){
        userService.deleteAdmin(user);
        return "redirect:/admin/list";
    }
}
