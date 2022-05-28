package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.DonationRepository;

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

}
