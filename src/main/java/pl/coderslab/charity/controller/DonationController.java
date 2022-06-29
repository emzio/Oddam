package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.*;

@AllArgsConstructor
@Controller
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final UserService userService;


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
        return "/donation/form-confirmation";
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

    @GetMapping("/user/donation/pickedup/{id}")
    private String donationPickUp(@PathVariable Long id){
        Donation donation = donationService.findByIdJoiningCategories(id);
        donation.setPickedUp(true);
        donationService.save(donation);
        return "redirect:/user/donations";
    }
}
