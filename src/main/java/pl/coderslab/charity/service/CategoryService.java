package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public List<Category> findAll();

    public Optional<Category> findById(Long id);
}
