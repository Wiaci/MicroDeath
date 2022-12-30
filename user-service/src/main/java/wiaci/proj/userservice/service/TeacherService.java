package wiaci.proj.userservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wiaci.proj.userservice.entity.Role;
import wiaci.proj.userservice.entity.Teacher;
import wiaci.proj.userservice.entity.User;
import wiaci.proj.userservice.feignClient.SubjectClient;
import wiaci.proj.userservice.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService{

    private final TeacherRepository teacherRepository;
    private final SubjectClient subjectClient;
    private final UserService userService;

    @Transactional
    public Teacher addTeacher(Teacher teacher) {
        User user = new User(teacher.getUser().getUsername(),
                teacher.getUser().getFirstname(),
                teacher.getUser().getLastname(),
                teacher.getUser().getPassword(),
                Role.TEACHER);

        Teacher t = new Teacher(user);
        userService.register(user);
        return teacherRepository.save(t);
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher findByUsername(String username) {
        return teacherRepository.findByUserUsername(username);
    }

    @Transactional
    public boolean deleteTeacher(Long id) {
        Teacher teacher = getTeacherById(id);
        if (teacher == null) return false;
        User user = teacher.getUser();
        teacherRepository.delete(teacher);
        userService.delete(user);
        return true;
    }

    @Transactional
    public Teacher update(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public void assignSubjects(Long teacherId, List<Long> subjectIds) {
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        if (teacher == null) return;
        subjectIds.forEach(id -> {
            teacher.getSubjects().addAll(subjectClient.findAllById(subjectIds));
        });
        update(teacher);
    }
}
