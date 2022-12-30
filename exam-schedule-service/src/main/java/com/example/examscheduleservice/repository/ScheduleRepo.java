package com.example.examscheduleservice.repository;

import com.example.examscheduleservice.entity.Schedule;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ScheduleRepo extends ReactiveCrudRepository<Schedule, Long> {
}
