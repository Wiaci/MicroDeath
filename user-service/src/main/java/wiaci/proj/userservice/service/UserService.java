package wiaci.proj.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import wiaci.proj.userservice.entity.User;
import wiaci.proj.userservice.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);

    }

    public List<User> getAll() {
        return null;
    }

    public User findById(Long id) {
        Optional<User> optional = userRepo.findById(id);
        return optional.orElse(null);
    }

    public User findByUsername(String name) {
        return userRepo.findByUsername(name);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

}
