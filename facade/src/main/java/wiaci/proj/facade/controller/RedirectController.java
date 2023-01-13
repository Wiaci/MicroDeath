package wiaci.proj.facade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wiaci.proj.facade.entity.*;
import wiaci.proj.facade.feignClient.ExamScheduleClient;
import wiaci.proj.facade.feignClient.GroupSubjectClient;
import wiaci.proj.facade.feignClient.UserClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RedirectController {

    private final UserClient userClient;
    private final ExamScheduleClient examScheduleClient;
    private final GroupSubjectClient groupSubjectClient;

    @GetMapping("/users/")
    public ResponseEntity<User> getUser(@RequestParam String name) {
        User user = userClient.getUser(name);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userClient.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users/new")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        User usr = userClient.addUser(user);
        if (user.equals(usr)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/users/delete")
    public ResponseEntity<Object> deleteUser(@RequestParam Long id) {
        userClient.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/students/")
    public ResponseEntity<Student> getStudent(@RequestParam Long id) {
        Student student = userClient.getStudent(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/students/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(userClient.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping("/students/new")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        Student s = userClient.addStudent(student);
        if (student.equals(s)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/students/delete")
    public ResponseEntity<Object> deleteStudent(@RequestParam Long id) {
        userClient.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/teachers/")
    public ResponseEntity<Teacher> getTeacher(@RequestParam String name) {
        Teacher teacher = userClient.getTeacher(name);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/teachers/all")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<>(userClient.getAllTeachers(), HttpStatus.OK);
    }

    @PostMapping("/teachers/new")
    public ResponseEntity<Object> addTeacher(@RequestParam Teacher teacher) {
        Teacher t = userClient.addTeacher(teacher);
        if (teacher.equals(t)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/teachers/delete")
    public ResponseEntity<Object> deleteTeacher(@RequestParam Long id) {
        userClient.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
///////////////////////////////////////////////////////////////////////////////
    @GetMapping("/groups/")
    public ResponseEntity<List<Group>> getGroups(@RequestParam Integer pageNum,
                          @RequestParam Integer pageCount) {
        return new ResponseEntity<>(groupSubjectClient.getGroups(pageNum, pageCount), HttpStatus.OK);
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable Long id) {
        Group group = groupSubjectClient.getGroup(id);
        if (group != null) {
            return new ResponseEntity<>(group, HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/groups/")
    public ResponseEntity<Object> addGroup(@RequestParam String name) {
        groupSubjectClient.addGroup(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/groups/delete/{id}")
    public ResponseEntity<Object> deleteGroup(@PathVariable Long id) {
        groupSubjectClient.deleteGroup(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/subjects/getAll")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(groupSubjectClient.getAllSubject(), HttpStatus.OK);
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable Long id) {
        Subject subject = groupSubjectClient.getSubject(id);
        if (subject != null) {
            return new ResponseEntity<>(subject, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/subjects/")
    public ResponseEntity<Object> addSubject(@RequestParam String name) {
        groupSubjectClient.addSubject(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/subjects/delete/{id}")
    public ResponseEntity<Object> deleteSubject(@PathVariable Long id) {
        groupSubjectClient.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

/////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/exams/{id}")
    public ResponseEntity<Exam> getExam(@PathVariable Long id) {
        Exam exam = examScheduleClient.getExam(id);
        if (exam != null) {
            return new ResponseEntity<>(exam, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/exams/getAll")
    public ResponseEntity<List<Exam>> getAllExams() {
        return new ResponseEntity<>(examScheduleClient.getAllExams(), HttpStatus.OK);
    }

    @PostMapping("/exams/")
    public ResponseEntity<Object> addExam(@RequestBody Exam exam) {
        Exam e = examScheduleClient.addExam(exam);
        if (exam.equals(e)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/exams/{id}")
    public ResponseEntity<Object> deleteExam(@PathVariable Long id) {
        examScheduleClient.deleteExam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable Long id) {
        Schedule schedule = examScheduleClient.getSchedule(id);
        if (schedule != null) {
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/schedule/getAll")
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        return new ResponseEntity<>(examScheduleClient.getAllSchedules(), HttpStatus.OK);
    }

    @PostMapping("/schedule/")
    public ResponseEntity<Object> addSchedule(@RequestBody Schedule schedule) {
        Schedule schedule1 = examScheduleClient.addSchedule(schedule);
        if (schedule.equals(schedule1)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<Object> deleteSchedule(@PathVariable Long id) {
        examScheduleClient.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
