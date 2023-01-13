package wiaci.proj.facade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import wiaci.proj.facade.dto.AuthenticationResponseDto;
import wiaci.proj.facade.entity.User;
import wiaci.proj.facade.feignClient.UserClient;
import wiaci.proj.facade.security.jwt.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserClient userClient;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestParam String username,
                                                           @RequestParam String password) {
        System.out.println("Hello!");
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authToken);
        User user = userClient.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        String token = jwtTokenProvider.createToken(username, user.getRole());
        return new ResponseEntity<>(AuthenticationResponseDto.fromUserAndToken(user, token), HttpStatus.OK);
    }

}
