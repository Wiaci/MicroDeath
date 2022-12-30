package com.example.examscheduleservice.controller;

import com.example.examscheduleservice.entity.Schedule;
import com.example.examscheduleservice.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/{id}")
    public Mono<Schedule> getById(@PathVariable Long id) {
        return scheduleService.getById(id);
    }

    @GetMapping("/getAll")
    public Flux<Schedule> getAll() {
        return scheduleService.getAll();
    }

    @PostMapping
    public Mono<Schedule> addSchedule(@RequestBody Schedule schedule) {
        return scheduleService.add(schedule);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteSchedule(@PathVariable Long id) {
        return scheduleService.deleteById(id);
    }


}
