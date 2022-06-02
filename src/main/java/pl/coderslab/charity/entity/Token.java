package pl.coderslab.charity.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Token {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private UUID token;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
