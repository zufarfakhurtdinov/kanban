package zufarfakhurtdinov.server.service;

import zufarfakhurtdinov.server.dto.TaskListDto;
import zufarfakhurtdinov.server.repository.TaskListRepository;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by dr on 07.05.2014.
 */
@Named
public class TaskListService {
    @Inject
    private TaskListRepository taskListRepository;

    public TaskListDto get(int id) {
        return taskListRepository.findOne( id );
    }

    public TaskListDto save(TaskListDto taskListDto) {
        return taskListRepository.save(taskListDto);
    }

    public boolean exists(int id) {
        return taskListRepository.exists(id);
    }

    public void delete(int id) {
        taskListRepository.delete( id );
    }
}
