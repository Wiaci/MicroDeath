package com.example.examscheduleservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
public class Exam {
    @Id
    private Long id;
    private Long studentId;
    private Long teacherId;
    private Long subjectId;
    private Date date;
    private Integer grade;
}
