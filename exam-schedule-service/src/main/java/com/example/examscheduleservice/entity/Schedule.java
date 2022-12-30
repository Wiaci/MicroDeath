package com.example.examscheduleservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
public class Schedule {
    @Id
    private Long id;
    private Long groupId;
    private Long subjectId;
    private Long teacherId;
    private Date date;
}
