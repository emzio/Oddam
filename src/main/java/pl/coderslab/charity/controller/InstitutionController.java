package pl.coderslab.charity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

@Controller
public class InstitutionController {
    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("admin/institutions")
    private String showAllInstitutions(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        return "institution/institutions";
    }

    @GetMapping("admin/institution/delete/{id}")
    private String showDeleteForm(Model model, @PathVariable Long id){
        Institution institution = institutionService.finById(id).orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
                });
        model.addAttribute("institution", institution);
        return "/institution/delete";
    }

    @PostMapping("admin/institution/delete/{id}")
    private String proceedDeleteForm(Institution institution){
        institutionService.delete(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("admin/institution/edit/{id}")
    private String showEditForm(@PathVariable Long id, Model model){
        Institution institution = institutionService.finById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
        model.addAttribute("institution", institution);
        return "/institution/edit";
    }

    @PostMapping("admin/institution/edit/{id}")
    private String proceedEditForm(Institution institution){
        institutionService.save(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("admin/institution/add")
    private String showAddForm(Model model){
        model.addAttribute("institution", new Institution());
        return "/institution/add";
    }

    @PostMapping("admin/institution/add")
    private String proceedAddForm(Institution institution){
        institutionService.add(institution);
        return "redirect:/admin/institutions";
    }
}
