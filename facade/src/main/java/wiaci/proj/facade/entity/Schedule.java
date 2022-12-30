package wiaci.proj.facade.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Schedule {
    private Long id;
    private String groupId;
    private String subjectId;
    private String teacherId;
    private Date date;

}
