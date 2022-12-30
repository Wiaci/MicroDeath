package wiaci.proj.facade.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import wiaci.proj.facade.entity.Student;
import wiaci.proj.facade.entity.Teacher;
import wiaci.proj.facade.entity.User;
import wiaci.proj.facade.feignClient.fallback.UserClientFallback;

import java.util.List;

@FeignClient(value = "users", url = "http://localhost:8765/", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("/users/")
    User getUser(@RequestParam String username);

    @GetMapping("/users/all")
    List<User> getAllUsers();

    @PostMapping("/users/new")
    User addUser(@RequestParam User user);

    @DeleteMapping("/users/delete")
    void deleteUser(@RequestParam Long id);

    @GetMapping("/students/")
    Student getStudent(@RequestParam Long id);

    @GetMapping("/students/all")
    List<Student> getAllStudents();

    @PostMapping("/students/new")
    Student addStudent(@RequestParam Student student);

    @DeleteMapping("/students/delete")
    void deleteStudent(@RequestParam Long id);

    @GetMapping("/teachers/")
    Teacher getTeacher(@RequestParam String username);

    @GetMapping("/teachers/all")
    List<Teacher> getAllTeachers();

    @PostMapping("/teachers/new")
    Teacher addTeacher(@RequestParam Teacher teacher);

    @DeleteMapping("/teachers/delete")
    void deleteTeacher(@RequestParam Long id);

}
