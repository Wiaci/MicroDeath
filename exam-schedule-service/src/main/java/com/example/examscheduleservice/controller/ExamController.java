package com.example.examscheduleservice.controller;

import com.example.examscheduleservice.entity.Exam;
import com.example.examscheduleservice.service.ExamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api1/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @GetMapping("/{id}")
    public Mono<Exam> getById(@PathVariable Long id) {
        log.info("Get request getById: " + id);
        return examService.getById(id);
    }

    @GetMapping("/getAll")
    public Flux<Exam> getAll() {
        log.info("Get request getAll");
        return examService.getAll();
    }

    @PostMapping
    public Mono<Exam> addExam(@RequestBody Exam exam) {
        log.info("Post request addExam: " + exam);
        return examService.add(exam);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteExam(@PathVariable Long id) {
        log.info("Delete request id: " + id);
        return examService.deleteById(id);
    }




}
