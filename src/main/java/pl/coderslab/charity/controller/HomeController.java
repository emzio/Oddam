package pl.coderslab.charity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("totalQuantity", donationService.findTotalQuantity());
        model.addAttribute("numberOfDonations", donationService.countDonation());
        return "index";
    }

//    TESTOWE TESTOWE TESTOWE TESTOWE TESTOWE testowe  testowe  testowe  testowe
    @GetMapping("/admin/test")
    @ResponseBody
    public String test(){
        return String.join(" | " , String.valueOf(donationService.findTotalQuantity()));
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/accestest")
    @ResponseBody
    public String accesTest() {
        return "passed or not";
    }
}
