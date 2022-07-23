package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.exceptions.OrderNotFoundException;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final DonationService donationService;

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category){
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id){
        categoryRepository.findById(id)
                .ifPresentOrElse(category -> {
                    donationService.findAllByCategory(category)
                            .forEach(donation -> {
                                donation.getCategories().removeIf(c -> c.getId().equals(category.getId()));
                                donationService.save(donation);
                            });
                    categoryRepository.delete(category);
                }, ()-> {throw new OrderNotFoundException();}
                );
    }

}
