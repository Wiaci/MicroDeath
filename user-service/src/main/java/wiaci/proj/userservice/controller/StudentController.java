package wiaci.proj.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import wiaci.proj.userservice.entity.Student;
import wiaci.proj.userservice.entity.Teacher;
import wiaci.proj.userservice.service.StudentService;
import wiaci.proj.userservice.service.TeacherService;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public Mono<Student> getStudent(@RequestParam Long id) {
        return Mono.just(studentService.getStudentById(id));
    }

    @GetMapping("/all")
    public Flux<Student> getAll() {
        return Flux.fromIterable(studentService.getAll());
    }

    @PostMapping("/new")
    public Mono<Student> addStudent(@RequestParam Student student) {
        return Mono.just(studentService.addStudent(student));
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
    }
}