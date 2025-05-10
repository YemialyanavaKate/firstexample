package by.users.yemialyanava.firstexample.models;

import jakarta.persistence.*;
import lombok.*;

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
    @OneToOne
    private Account account;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PhoneData> phones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<EmailData> emails;
}
