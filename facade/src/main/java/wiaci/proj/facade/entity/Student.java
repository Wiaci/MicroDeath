package wiaci.proj.facade.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Student {
    private Long id;
    private String userId;
    private String groupId;
}
