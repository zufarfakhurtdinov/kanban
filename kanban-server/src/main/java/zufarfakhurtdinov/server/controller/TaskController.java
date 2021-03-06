package zufarfakhurtdinov.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import zufarfakhurtdinov.common.dto.TaskDto;
import zufarfakhurtdinov.server.service.TaskService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dr on 28.04.2014.
 */
@RestController
public class TaskController {

    @Inject
    TaskService taskService;

    @RequestMapping( value = "/task/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDto getTask( @PathVariable int id, HttpServletResponse response){
        TaskDto result = taskService.get(id);
        if( result == null ) {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
            return null;
        }
        return result;
    }

    @RequestMapping( value = "/task/{id}", method = RequestMethod.PUT )
    public void changeTask( @PathVariable int id, @RequestBody TaskDto taskDto, HttpServletResponse response){
        if( taskDto.id == null || id != taskDto.id ) {
            response.setStatus( HttpServletResponse.SC_BAD_REQUEST );
            return;
        }
        TaskDto oldValue = taskService.get(id);
        if( oldValue == null ) {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
            return;
        }
        taskService.save(taskDto);
    }

    @RequestMapping( value = "/task", method = RequestMethod.POST)
    public TaskDto addTask( @RequestBody TaskDto taskDto, HttpServletResponse response){
        if( taskDto == null || taskDto.id != null ) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        response.setStatus(HttpServletResponse.SC_CREATED);

        return taskService.save( taskDto );
    }

    @RequestMapping( value = "/task/{id}", method = RequestMethod.DELETE)
    public void deleteTask( @PathVariable int id, HttpServletResponse response){
        if( taskService.exists( id ) ) {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
            return;
        }
        taskService.delete(id);
    }
}
