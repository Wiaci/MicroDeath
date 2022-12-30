package com.example.examscheduleservice.repository;

import com.example.examscheduleservice.entity.Exam;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ExamRepo extends ReactiveCrudRepository<Exam, Long> {
}
