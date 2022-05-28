package pl.coderslab.charity.service;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;

public interface DonationService {
    void save(User user, Donation donation);

    Integer findTotalQuantity();

    Integer countDonation();

}
