package zufarfakhurtdinov.server.service;

import zufarfakhurtdinov.common.dto.BoardDto;
import zufarfakhurtdinov.server.repository.BoardRepository;

import javax.inject.Inject;

/**
 * Created by dr on 11.05.2014.
 */
public class BoardService {

    @Inject
    BoardRepository boardRepository;

    public BoardDto get( int id ) {
        return boardRepository.findOne( id );
    }
}
