package wiaci.proj.facade.feignClient.fallback;

import org.springframework.stereotype.Component;
import wiaci.proj.facade.entity.Student;
import wiaci.proj.facade.entity.Teacher;
import wiaci.proj.facade.entity.User;
import wiaci.proj.facade.feignClient.UserClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>();
    }

    @Override
    public Student addStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
    }

    @Override
    public Teacher getTeacher(String username) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return new ArrayList<>();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public void deleteTeacher(Long id) {
    }
}
