package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class DonationServiceImp implements DonationService{
    private final DonationRepository donationRepository;

    public DonationServiceImp(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public void save(User user, Donation donation){
        donation.setUser(user);
        donation.setPickedUp(false);
        donationRepository.save(donation);
    }

    @Override
    public Integer countDonation(){
        return donationRepository.countDonation();
    }

    @Override
    public Integer findTotalQuantity() {
        return donationRepository.findTotalQuantity();
    }

    @Override
    public List<Donation>  findAllByUserOrderByPickedUp(User user){
        List<Donation> donations = donationRepository.findAllByUserOrderByPickedUp(user);
        Collections.sort(donations);
        return donations;
    }

    @Override
    public Donation findByIdJoiningCategories(Long id){
        return donationRepository.findByIdJoiningCategories(id);
    }

    @Override
    public void save(Donation donation){
        donationRepository.save(donation);
    }

}
