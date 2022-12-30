package wiaci.proj.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiaci.proj.userservice.entity.Teacher;
import wiaci.proj.userservice.entity.User;
import wiaci.proj.userservice.service.TeacherService;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByUserUsername(String username);

}
