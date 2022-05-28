package pl.coderslab.charity.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;

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
    @Override
    public List<Institution> findAllByEnabledIsTrue(){
        return institutionRepository.findAllByEnabledIsTrue();
    }

    @Override
    public Institution finById(Long id) {
        return institutionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
    }

    public void delete(Institution institution){
        institution.setEnabled(false);
        institutionRepository.save(institution);
    }

    public void save(Institution institution){
        institutionRepository.save(institution);
    }
}
