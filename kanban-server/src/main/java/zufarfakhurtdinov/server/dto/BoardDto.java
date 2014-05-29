package zufarfakhurtdinov.server.dto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dr on 11.05.2014.
 */
@Entity
@Table(name = "Boards")
public class BoardDto {

    @Id
    @Column(name = "id")
    public Integer id;

    @OneToMany
    public List<TaskListDto> taskLists;

}
