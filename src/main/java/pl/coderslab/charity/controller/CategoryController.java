package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.exceptions.OrderNotFoundException;
import pl.coderslab.charity.service.CategoryService;

@AllArgsConstructor
@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/admin/categories")
    public String showList(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/admin/category/edit/{id}")
    public String showEditForm(Model model, @PathVariable Long id){
        categoryService.findById(id)
                .ifPresentOrElse(model::addAttribute, ()-> {
                    throw new OrderNotFoundException();
                });
        return "category/edit";
    }
}
