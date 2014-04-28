package zufarfakhurtdinov.server.dto;

/**
 * Created by dr on 28.04.2014.
 */
public class TaskDto {
    public TaskDto() {
    }

    public TaskDto(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int id;
    public String text;
}
