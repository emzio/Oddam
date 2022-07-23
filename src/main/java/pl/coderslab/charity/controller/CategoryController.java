package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.entity.Category;
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

    @PostMapping("/admin/category/edit/{id}")
    public String proceedEditForm(Category category){
        categoryService.save(category);
        return"redirect:/admin/categories";
    }

    @GetMapping("admin/category/add")
    public String showAddForm(Model model){
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/admin/category/add")
    public String proceedAddForm(Category category){
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("admin/category/delete/{id}")
    public String showDeleteForm(@PathVariable Long id){
        return "category/delete";
    }

    @PostMapping("admin/category/delete/{id}")
    public String proceedDeleteForm(@PathVariable Long id){
        categoryService.delete(id);
        return "redirect:/admin/categories";
    }
}
