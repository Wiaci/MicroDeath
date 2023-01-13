package com.example.examscheduleservice;

import com.example.examscheduleservice.controller.ExamController;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
class ExamScheduleServiceApplicationTests {

    private final ExamController examController;

    @Test
    void contextLoads() {

    }

}
