package zufarfakhurtdinov.server.controller;

import org.springframework.web.bind.annotation.*;
import zufarfakhurtdinov.server.dto.TaskDto;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dr on 28.04.2014.
 */
@RestController
public class TaskController {

    @RequestMapping( value = "/task/{id}", method = RequestMethod.GET, produces = "application/json")
    public TaskDto getTask( @PathVariable int id, HttpServletResponse response){
        TaskDto result = testStupidMap.get( id );
        if( result == null ) {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
            return null;
        }
        return result;
    }

    @RequestMapping( value = "/task/{id}", method = RequestMethod.PUT )
    public void changeTask( @PathVariable int id, @RequestBody TaskDto taskDto, HttpServletResponse response){
        TaskDto result = testStupidMap.get( id );
        if( result == null ) {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
            return;
        }
        if( id != taskDto.id ) {
            response.setStatus( HttpServletResponse.SC_BAD_REQUEST );
            return;
        }
        testStupidMap.put( taskDto.id, taskDto );
    }

    @RequestMapping( value = "/task", method = RequestMethod.POST)
    public TaskDto addTask( @RequestBody TaskDto taskDto, HttpServletResponse response){
        if( taskDto == null ) {
            //todo: check the code
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        taskDto.id = counter.getAndIncrement();
        testStupidMap.put(taskDto.id, taskDto);
        return taskDto;
    }

    @RequestMapping( value = "/task/{id}", method = RequestMethod.DELETE)
    public void deleteTask( @PathVariable int id, HttpServletResponse response){
        TaskDto result = testStupidMap.remove( id );
        if( result == null ) {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
            return;
        }
    }




    private static Map<Integer, TaskDto> createTestMap(){
        Map<Integer, TaskDto> result = new ConcurrentHashMap<>();
        for( int i = 0; i<10; i++) {
            result.put(i, new TaskDto(i, "text"+i));
        }
        return result;
    }


    //TODO: change with any better solution
    private static final Map<Integer, TaskDto> testStupidMap = createTestMap();
    private static final AtomicInteger counter = new AtomicInteger(10);
}
