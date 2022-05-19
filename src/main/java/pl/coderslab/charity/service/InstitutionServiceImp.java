package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@Transactional
public class InstitutionServiceImp implements InstitutionService{
    private final InstitutionRepository institutionRepository;


    public InstitutionServiceImp(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }


    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }
}
