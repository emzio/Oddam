package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.service.EmailService;

@Controller
@AllArgsConstructor
public class ContactController {
    private final EmailService emailService;

    @PostMapping("/contact")
    public String showConfirmation(@RequestParam String name, @RequestParam String surname, @RequestParam String message){
        if(name!=null&&surname!=null&&message!=null){
            emailService.sendSimpleMessage("emzioemailtest@gmail.com", String.join(" ", name, surname), message);
            return "contact/confirmation";
        }
        return "redirect:/";
    }
}
