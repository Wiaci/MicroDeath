package com.example.examscheduleservice.service;

import com.example.examscheduleservice.entity.Exam;
import com.example.examscheduleservice.repository.ExamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepo examRepo;

    public Mono<Exam> getById(Long id) {
        return examRepo.findById(id);
    }

    public Flux<Exam> getAll() {
        return examRepo.findAll();
    }

    public Mono<Exam> add(Exam exam) {
        return examRepo.save(exam);
    }

    public Mono<Void> deleteById(Long id) {
        return examRepo.deleteById(id);
    }



}
