package zufarfakhurtdinov.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import zufarfakhurtdinov.server.dto.BoardDto;
import zufarfakhurtdinov.server.service.BoardService;

import javax.inject.Inject;

/**
 * Created by dr on 28.04.2014.
 */
@RestController
public class BoardController {

    @Inject
    BoardService boardService;

    @RequestMapping(value = "/board/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoardDto> getBoard( @PathVariable int id, UriComponentsBuilder uriComponentsBuilder){
        BoardDto result = boardService.get(id);
        if( result == null ) {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        ResponseEntity<BoardDto> entity = new ResponseEntity<>(result, HttpStatus.CREATED);
        UriComponents uriComponents = uriComponentsBuilder.path("/board/{id}").buildAndExpand(id);
        entity.getHeaders().setLocation(uriComponents.toUri());
        return entity;
    }

}
