package wiaci.proj.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usr", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstname;
    private String lastname;
    private String password;

    @Column(name = "last_password_reset_date")
    private Date lastPasswordResetDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String firstname, String lastname, String password, Role role) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        lastPasswordResetDate = new Date();
        this.role = role;
    }
}
