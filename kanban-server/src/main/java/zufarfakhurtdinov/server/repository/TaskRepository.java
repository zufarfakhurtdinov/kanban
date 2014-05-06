package zufarfakhurtdinov.server.repository;

import org.springframework.data.repository.CrudRepository;
import zufarfakhurtdinov.server.dto.TaskDto;

/**
 * Created by dr on 05.05.2014.
 */
public interface TaskRepository extends CrudRepository<TaskDto,Integer>{
}
