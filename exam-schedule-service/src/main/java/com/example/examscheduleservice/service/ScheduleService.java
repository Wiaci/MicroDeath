package com.example.examscheduleservice.service;

import com.example.examscheduleservice.entity.Exam;
import com.example.examscheduleservice.entity.Schedule;
import com.example.examscheduleservice.repository.ScheduleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepo scheduleRepo;

    public Mono<Schedule> getById(Long id) {
        return scheduleRepo.findById(id);
    }

    public Flux<Schedule> getAll() {
        return scheduleRepo.findAll();
    }

    public Mono<Schedule> add(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }

    public Mono<Void> deleteById(Long id) {
        return scheduleRepo.deleteById(id);
    }

}

