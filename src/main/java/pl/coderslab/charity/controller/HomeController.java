package pl.coderslab.charity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.service.*;


@Controller
public class HomeController {

    private final EmailService emailService;
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;
    public HomeController(EmailService emailService, InstitutionService institutionService, DonationService donationService, UserService userService) {
        this.emailService = emailService;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }


    @RequestMapping("/")
    public String homeAction(Model model, @AuthenticationPrincipal CurrentUser customUser){
        model.addAttribute("institutions", institutionService.findAllByEnabledIsTrue());
        model.addAttribute("totalQuantity", donationService.findTotalQuantity());
        model.addAttribute("numberOfDonations", donationService.countDonation());

        if(customUser!=null && userService.findRole(customUser).getName().equals("ROLE_ADMIN")){
            return "admin/admin";
        } else if (customUser!=null){
            return "user/user";
        }
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

        return userService.count() + " passed or not";
    }

    @GetMapping("/email")
    @ResponseBody
    private String emailTest(){
        emailService.sendSimpleMessage("emzio@yahoo.com", "emailTest", "test text");
        return "email test";
    }

}
