package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

@Controller
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

//ADD
    @GetMapping("/user/donation/add")
    private String showAddForm(Model model){
        model.addAttribute("donation",new Donation());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        return "donation/add";
    }

    @PostMapping("/user/donation/add")
    private String proceedAddForm(Donation donation){
        donationService.save(donation);
        return "redirect:/user/donation/confirmation";
    }

    @GetMapping("/user/donation/confirmation")
    public String showConfirmation(){
        return "form-confirmation";
    }


}
