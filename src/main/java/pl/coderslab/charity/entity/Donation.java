package pl.coderslab.charity.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Donation implements Comparable<Donation>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;

    private Integer quantity;

    @ManyToMany
    @JoinColumn
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Institution institution;

    @ManyToOne
    @JoinColumn
    private User user;

    private String street;
    private String city;
    private String zipCode;
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickedUpDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickedUpTime;
    private String pickUpComment;

    private Boolean pickedUp;

    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdOn;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getPickedUpDate() {
        return pickedUpDate;
    }

    public void setPickedUpDate(LocalDate pickedUpDate) {
        this.pickedUpDate = pickedUpDate;
    }

    public LocalTime getPickedUpTime() {
        return pickedUpTime;
    }

    public void setPickedUpTime(LocalTime pickedUpTime) {
        this.pickedUpTime = pickedUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }

    public Boolean getPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(Boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", institution=" + institution +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", pickedUpDate=" + pickedUpDate +
                ", pickedUpTime=" + pickedUpTime +
                ", pickUpComment='" + pickUpComment + '\'' +
                '}';
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public int compareTo(Donation donation) {
        if (this.getPickedUp().compareTo(donation.pickedUp)==0){
            return (this.pickedUp==false ?
                    this.getCreatedOn().compareTo(donation.createdOn) :
                    this.getPickedUpDate().compareTo(donation.pickedUpDate));
        }

        return this.getPickedUp().compareTo(donation.pickedUp);
    }
}
