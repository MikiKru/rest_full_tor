package pl.sda.restfull.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id                                             // PK
    @GeneratedValue(strategy = GenerationType.AUTO) // AI
    private Long id;
    private String email;
    private String password;
    private LocalDateTime register_date = LocalDateTime.now();
    private boolean activity = false;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
