package wiaci.proj.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import wiaci.proj.facade.entity.User;

@Data
@AllArgsConstructor
public class AuthenticationResponseDto {
    private String token;
    private String username;
    private String firstname;
    private String lastname;

    public static AuthenticationResponseDto fromUserAndToken(User user, String token) {
        return new AuthenticationResponseDto(
                token,
                user.getUsername(),
                user.getFirstname(),
                user.getLastname());
    }
}
