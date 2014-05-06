package zufarfakhurtdinov.server.dto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dr on 05.05.2014.
 */
@Entity
@Table(name="TASKLIST")
public class TaskListDto {

    @Id
    @Column(name = "id")
    public Integer id;

    @OneToMany
    public List<TaskDto> tasks;
}
