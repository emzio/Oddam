package pl.coderslab.charity.controller;

import ch.qos.logback.classic.spi.IThrowableProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class AdminsController {

    private final UserService userService;
    private final RoleService roleService;


    @GetMapping("admin/list")
    private String showAllAdmins(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        model.addAttribute("admins", userService.findAllAdmins());
        model.addAttribute("userToCompare", userService.findByUserName(currentUser.getUsername()));
        return "admin/list";
    }

    @GetMapping("admin/delete/{id}")
    private String showDeleteForm( @PathVariable Long id, Model model){
        userService.findById(id).ifPresentOrElse(user -> model.addAttribute("admin", user), () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
        return "admin/delete";
    }

    @PostMapping("admin/delete/{id}")
    private String proceedDeleteForm(@AuthenticationPrincipal CurrentUser currentUser, User user){
        User userToCompare = userService.findByUserName(currentUser.getUsername());
        userService.deleteAdmin(userToCompare, user);
        return "redirect:/admin/list";
    }

    @GetMapping("admin/add")
    private String showAddForm(Model model){
        model.addAttribute("user", new User());
        return "admin/add";
    }

    @PostMapping("admin/add")
    private String proceedAddForm(@Valid User user, BindingResult result, @RequestParam String passwordRep){
        if(result.hasErrors() || !userService.verifyPasswordRepetition(user.getPassword(),passwordRep) || userService.dataRepetitionFound(user)
        ){
            return "admin/add";
        }
        userService.saveAdmin(user);
        return "redirect:/admin/list";
    }

    @GetMapping("admin/edit/{id}")
    private String showEditForm(@PathVariable Long id, Model model){
        userService.findById(id).ifPresentOrElse(user -> model.addAttribute("user", user), () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
                });
        return "admin/edit";
    }

    @PostMapping("admin/edit/{id}")
    private String proceedAddForm(@Valid User user, BindingResult result){
        if (userService.dataRepetitionFound(user) || result.hasErrors()){
            return "admin/edit";
        }
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
        userService.findById(id).ifPresentOrElse(user -> {
            model.addAttribute("allRoles", roleService.findAll());
            model.addAttribute("user", user);
        }, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });

        return "admin/user-edit";
    }

    @PostMapping("admin/user/edit/{id}")
    private String proceedUserEditForm(@Valid User user, BindingResult result, Model model){
        if (userService.dataRepetitionFound(user) || result.hasErrors()){
            model.addAttribute("allRoles", roleService.findAll());
            return "admin/user-edit";
        }
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("admin/user/delete/{id}")
    private String showUserDeleteForm(@PathVariable Long id, Model model){
        userService.findById(id).ifPresentOrElse(user -> model.addAttribute("user", user), () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
        return "admin/user-delete";
    }
    @PostMapping("admin/user/delete/{id}")
    private String proceedUserDeleteForm(User user){
        userService.deleteUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("admin/user/disable/{id}")
    private String disableUser(@PathVariable Long id){
        userService.findById(id).ifPresentOrElse(userService::disableUser, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
                });
        return "redirect:/admin/users";
    }

}
