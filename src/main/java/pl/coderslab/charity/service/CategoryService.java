package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void save(Category category) ;

    List<Category> findAll();

    Optional<Category> findById(Long id);

    void delete(Long id);
}
