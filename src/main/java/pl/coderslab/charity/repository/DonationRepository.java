package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d ")
    Integer findTotalQuantity();

    @Query("SELECT COUNT(d) FROM Donation d ")
    Integer countDonation();

    List<Donation> findAllByUserOrderByPickedUp(User user);

    @Query("SELECT d FROM Donation d JOIN d.categories WHERE d.id=?1")
    Donation findByIdJoiningCategories(Long id);
//    FETCH
}
