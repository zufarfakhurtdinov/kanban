package zufarfakhurtdinov.server.repository;

import org.springframework.data.repository.CrudRepository;
import zufarfakhurtdinov.server.dto.BoardDto;

/**
 * Created by dr on 11.05.2014.
 */
public interface BoardRepository extends CrudRepository<BoardDto, Integer>{
}
