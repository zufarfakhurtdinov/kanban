package zufarfakhurtdinov.server.repository;

import org.springframework.data.repository.CrudRepository;
import zufarfakhurtdinov.server.dto.TaskListDto;

/**
 * Created by dr on 07.05.2014.
 */
public interface TaskListRepository extends CrudRepository<TaskListDto, Integer> {
}
