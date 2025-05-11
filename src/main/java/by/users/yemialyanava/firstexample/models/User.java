package by.users.yemialyanava.firstexample.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PhoneData> phones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<EmailData> emails;

    @PrePersist
    public void createAccount() {
        if (this.account == null) {
            this.account = new Account();
            this.account.setBalance(BigDecimal.valueOf(9000));
            this.account.setUser(this);
        }
    }
}
