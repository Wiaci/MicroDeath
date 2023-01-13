package com.example.examscheduleservice.controller;

import com.example.examscheduleservice.entity.Schedule;
import com.example.examscheduleservice.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api1/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/{id}")
    public Mono<Schedule> getById(@PathVariable Long id) {
        log.info("Get request for getById: " + id);
        return scheduleService.getById(id);
    }

    @GetMapping("/getAll")
    public Flux<Schedule> getAll() {
        log.info("Get request for getAll");
        return scheduleService.getAll();
    }

    @PostMapping
    public Mono<Schedule> addSchedule(@RequestBody Schedule schedule) {
        log.info("Post request for addSchedule: " + schedule);
        return scheduleService.add(schedule);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteSchedule(@PathVariable Long id) {
        log.info("Delete request for deleteSchedule with id: " + id);
        return scheduleService.deleteById(id);
    }


}
