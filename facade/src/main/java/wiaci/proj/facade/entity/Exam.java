package wiaci.proj.facade.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Exam {
    private Long id;
    private String studentId;
    private String teacherId;
    private String subjectId;
    private Date date;
    private Integer grade;
}
