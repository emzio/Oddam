package pl.coderslab.charity.service;

import com.sun.xml.bind.v2.TODO;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;

import java.util.List;

public interface DonationService {
    void save(User user, Donation donation);

    Integer findTotalQuantity();

    Integer countDonation();

    List<Donation> findAllByUserOrderByPickedUp(User user);

    Donation findByIdJoiningCategories(Long id);

    void save(Donation donation);


    void setPickedUp(Long id);
}
