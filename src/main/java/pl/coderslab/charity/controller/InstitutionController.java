package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

@Controller
public class InstitutionController {
    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("admin/institutions")
    private String showAllDonations(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        return "institution/institutions";
    }

    @GetMapping("admin/institution/delete/{id}")
    private String showDeleteForm(Model model, @PathVariable Long id){
        model.addAttribute("institution", institutionService.finById(id));
        return "/institution/delete";
    }

    @PostMapping("admin/institution/delete/{id}")
    private String proceedDeleteForm(Institution institution){
        institutionService.delete(institution);
        return "redirect:/admin/institutions";
    }
}
