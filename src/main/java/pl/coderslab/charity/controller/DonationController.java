package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/user/donations")
    private String showAllUserDonations(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        User user = userService.findByUserName(currentUser.getUsername());
        model.addAttribute("donations", donationService.findAllByUserOrderByPickedUp(user));
        return "donation/user-donations";
    }

    @GetMapping("/user/donation/details/{id}")
    private String showDonationDetails(@PathVariable Long id, Model model){
        model.addAttribute("donation", donationService.findByIdJoiningCategories(id));
        return "donation/details";
    }

    @GetMapping("/user/donation/details/{id}")
    private String donationPickUp(@PathVariable Long id){

        return "donation/details";
    }
}
