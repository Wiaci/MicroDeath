package wiaci.proj.facade.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private Date lastPasswordResetDate;
    private Role role;
}
