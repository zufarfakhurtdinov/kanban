package zufarfakhurtdinov.server.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dr on 28.04.2014.
 */
@Entity
@Table(name="TASKS")
public class TaskDto {
    public TaskDto() {
    }

    public TaskDto(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    @Id
    @Column(name = "id")
    public Integer id;
    public String text;
}
