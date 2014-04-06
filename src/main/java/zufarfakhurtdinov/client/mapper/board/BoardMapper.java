package zufarfakhurtdinov.client.mapper.board;

import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.Event;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.MapperFactory;
import jetbrains.jetpad.mapper.gwt.WithElement;
import zufarfakhurtdinov.client.mapper.tasklist.TaskListMapper;
import zufarfakhurtdinov.client.model.Board;
import zufarfakhurtdinov.client.model.TaskList;

import static com.google.gwt.query.client.GQuery.$;
import static jetbrains.jetpad.mapper.Synchronizers.forObservableRole;
import static jetbrains.jetpad.mapper.gwt.DomUtil.withElementChildren;

/**
 * Created by dr on 06.04.2014.
 */
public class BoardMapper extends Mapper<Board, BoardView> {
    public BoardMapper(Board source) {
        super(source, new BoardView());

        $(getTarget().addNew).click( new Function() {
            @Override
            public boolean f(Event e) {
                TaskList taskList = new TaskList();
                taskList.name.set( "new tasklist" );
                getSource().items.add( taskList );
                return false;
            }
        });
    }

    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers(conf);
        conf.add(forObservableRole(this, getSource().items, withElementChildren(getTarget().main), new MapperFactory<TaskList, WithElement>() {
            @Override
            public Mapper<? extends TaskList, ? extends WithElement> createMapper(TaskList source) {
                return new TaskListMapper(source);
            }
        }));
    }
}