package zufarfakhurtdinov.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import zufarfakhurtdinov.server.dto.TaskListDto;
import zufarfakhurtdinov.server.service.TaskListService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dr on 07.05.2014.
 */
@RestController("/taskList")
public class TaskListController {

    @Inject
    private TaskListService taskListService;

    @RequestMapping( value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskListDto get(@PathVariable int id, HttpServletResponse response) {
        TaskListDto taskListDto = taskListService.get(id);
        if( taskListDto == null ) {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
            return null;
        }
        return taskListDto;
    }

    @RequestMapping( method = RequestMethod.POST )
    public TaskListDto add( @RequestBody TaskListDto taskListDto, HttpServletResponse response) {
        if( taskListDto == null || taskListDto.id != null ) {
            response.setStatus( HttpServletResponse.SC_BAD_REQUEST );
            return null;
        }
        return taskListService.save( taskListDto);
    }

    @RequestMapping ( value = "/{id}", method = RequestMethod.PUT)
    public void change( @PathVariable int id, @RequestBody TaskListDto taskListDto, HttpServletResponse response ) {
        if( taskListDto.id == null || id != taskListDto.id ) {
            response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        TaskListDto oldValue = taskListService.get( id );
        if( oldValue == null ) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        taskListService.save( taskListDto );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public void delete( @PathVariable int id, HttpServletResponse response ) {
        if( !taskListService.exists(id) ) {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
            return;
        }
        taskListService.delete(id);
    }
}
