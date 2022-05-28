package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.*;

@Controller
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final UserService userService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService, UserService userService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.userService = userService;
    }

//ADD
    @GetMapping("/user/donation/add")
    private String showAddForm(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        model.addAttribute("userPhone", userService.findByUserName(currentUser.getUsername()).getPhone());
        model.addAttribute("donation",new Donation());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAllByEnabledIsTrue());
        return "donation/add";
    }

    @PostMapping("/user/donation/add")
    private String proceedAddForm(@AuthenticationPrincipal CurrentUser currentUser, Donation donation){
        User user = userService.findByUserName(currentUser.getUsername());
        donationService.save(user, donation);
        return "redirect:/user/donation/confirmation";
    }

    @GetMapping("/user/donation/confirmation")
    public String showConfirmation(){
        return "form-confirmation";
    }


}
