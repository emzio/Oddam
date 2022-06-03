package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import java.io.File;
import java.util.UUID;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;


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

    @GetMapping("/uuid")
    @ResponseBody
    public String uuidGenerator(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @GetMapping("/path")
    @ResponseBody
    public String  pathTest(HttpServletRequest request){
        return "ContextPath :" + request.getContextPath()
                + "url: " + request.getRequestURL().toString();
    }

}
