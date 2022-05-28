package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    List<Institution> findAll();

    List<Institution> findAllByEnabledIsTrue();

    Institution finById(Long id);

    void delete(Institution institution);
}
