package wiaci.proj.groupsubjectservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wiaci.proj.groupsubjectservice.entity.Subject;
import wiaci.proj.groupsubjectservice.service.SubjectService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api1/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/getAll")
    public List<Subject> getAll() {
        return subjectService.getAll();
    }

    @GetMapping("/{id}")
    public Subject findById(@PathVariable Long id) {
        return subjectService.getById(id);
    }

    @PostMapping
    public void addSubject(@RequestParam String name) throws SQLException {
        subjectService.addSubject(name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubject(@PathVariable Long id) throws SQLException {
        subjectService.delete(id);
    }

}
