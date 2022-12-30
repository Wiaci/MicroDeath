package com.example.examscheduleservice.controller;

import com.example.examscheduleservice.entity.Exam;
import com.example.examscheduleservice.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @GetMapping("/{id}")
    public Mono<Exam> getById(@PathVariable Long id) {
        return examService.getById(id);
    }

    @GetMapping("/getAll")
    public Flux<Exam> getAll() {
        return examService.getAll();
    }

    @PostMapping
    public Mono<Exam> addExam(@RequestBody Exam exam) {
        return examService.add(exam);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteExam(@PathVariable Long id) {
        return examService.deleteById(id);
    }




}
