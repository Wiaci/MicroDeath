package wiaci.proj.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiaci.proj.userservice.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    public User findByUsername(String username);

}
