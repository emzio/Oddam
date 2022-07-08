package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;

    @RequestMapping("/")
    public String homeAction(Model model, @AuthenticationPrincipal CurrentUser customUser){
        if(customUser!=null && userService.findRolesNames(customUser).contains("ROLE_ADMIN")){
            return "redirect:/admin/admin";
        } else if (customUser!=null) {
            return "redirect:/home";
        }
        model.addAttribute("institutions", institutionService.findAllByEnabledIsTrue());
        model.addAttribute("totalQuantity", donationService.findTotalQuantity());
        model.addAttribute("numberOfDonations", donationService.countDonation());
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("institutions", institutionService.findAllByEnabledIsTrue());
        model.addAttribute("totalQuantity", donationService.findTotalQuantity());
        model.addAttribute("numberOfDonations", donationService.countDonation());
        return "user/home";
    }
}
