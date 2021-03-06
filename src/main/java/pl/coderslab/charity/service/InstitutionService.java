package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    List<Institution> findAll();

    List<Institution> findAllByEnabledIsTrue();

    Optional<Institution> finById(Long id);

    void delete(Institution institution);

    void save(Institution institution);

    void add(Institution institution);
}
