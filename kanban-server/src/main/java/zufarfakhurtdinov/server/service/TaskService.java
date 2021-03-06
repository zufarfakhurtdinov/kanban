package zufarfakhurtdinov.server.service;

import org.springframework.stereotype.Component;
import zufarfakhurtdinov.common.dto.TaskDto;
import zufarfakhurtdinov.server.repository.TaskRepository;

import javax.inject.Inject;

/**
 * Created by dr on 07.05.2014.
 */
@Component
public class TaskService {

    @Inject
    TaskRepository taskRepository;

    public TaskDto get(Integer id) {
        return taskRepository.findOne( id );
    }

    public TaskDto save(TaskDto task) {
        return taskRepository.save(task);
    }

    public boolean exists( Integer id ) {
        return taskRepository.exists( id );
    }

    public void delete( Integer id ) {
        taskRepository.delete( id );
    }
}
