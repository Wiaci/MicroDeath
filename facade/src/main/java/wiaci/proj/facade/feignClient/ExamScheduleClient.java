package wiaci.proj.facade.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import wiaci.proj.facade.entity.Exam;
import wiaci.proj.facade.entity.Schedule;
import wiaci.proj.facade.feignClient.fallback.ExamClientFallback;

import java.util.List;

@FeignClient(value = "exam-schedules", url = "http://localhost:8765/", fallback = ExamClientFallback.class)
public interface ExamScheduleClient {

    @GetMapping("/exams/{id}")
    Exam getExam(@PathVariable Long id);

    @GetMapping("/exams/getAll")
    List<Exam> getAllExams();

    @PostMapping("/exams/")
    Exam addExam(@RequestBody Exam exam);

    @DeleteMapping("/exams/{id}")
    void deleteExam(@PathVariable Long id);

    @GetMapping("/schedule/{id}")
    Schedule getSchedule(@PathVariable Long id);

    @GetMapping("/schedule/getAll")
    List<Schedule> getAllSchedules();

    @PostMapping("/schedule/")
    Schedule addSchedule(@RequestBody Schedule schedule);

    @DeleteMapping("/schedule/{id}")
    void deleteSchedule(@PathVariable Long id);







}
