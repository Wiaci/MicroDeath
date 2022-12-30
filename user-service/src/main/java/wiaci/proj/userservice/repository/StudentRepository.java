package wiaci.proj.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiaci.proj.userservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
