package wiaci.proj.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import wiaci.proj.userservice.entity.Teacher;
import wiaci.proj.userservice.entity.User;
import wiaci.proj.userservice.service.TeacherService;
import wiaci.proj.userservice.service.UserService;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public Mono<Teacher> getTeacher(@RequestParam String username) {
        return Mono.just(teacherService.findByUsername(username));
    }

    @GetMapping("/all")
    public Flux<Teacher> getAll() {
        return Flux.fromIterable(teacherService.getAll());
    }

    @PostMapping("/new")
    public Mono<Teacher> addTeacher(@RequestParam Teacher teacher) {
        return Mono.just(teacherService.addTeacher(teacher));
    }

    @DeleteMapping("/delete")
    public void deleteTeacher(@RequestParam Long id) {
        teacherService.deleteTeacher(id);
    }
}
