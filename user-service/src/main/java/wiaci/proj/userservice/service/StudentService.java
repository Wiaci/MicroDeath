package wiaci.proj.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wiaci.proj.userservice.entity.Group;
import wiaci.proj.userservice.entity.Role;
import wiaci.proj.userservice.entity.Student;
import wiaci.proj.userservice.entity.User;
import wiaci.proj.userservice.feignClient.GroupClient;
import wiaci.proj.userservice.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService{

    private final StudentRepository studentRepository;
    private final GroupClient groupClient;
    private final UserService userService;

    @Transactional
    public Student addStudent(Student student) {
        Group group = groupClient.findById(student.getGroup().getId());
        if (group != null) return null;
        User user = new User(student.getUser().getUsername(),
                student.getUser().getFirstname(),
                student.getUser().getLastname(),
                student.getUser().getPassword(),
                Role.STUDENT);

        Student s = new Student(user, group);
        userService.register(user);
        return studentRepository.save(s);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Transactional
    public boolean deleteStudent(Long id) {
        Student student = getStudentById(id);
        if (student == null) return false;
        User user = student.getUser();
        studentRepository.delete(student);
        userService.delete(user);
        return true;
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }


    @Transactional
    public Student update(Student student) {
        return studentRepository.save(student);
    }




}
