package zufarfakhurtdinov.client.mapper.board;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.MapperFactory;
import zufarfakhurtdinov.client.common.WidgetChildList;
import zufarfakhurtdinov.client.mapper.tasklist.TaskListMapper;
import zufarfakhurtdinov.client.model.Board;
import zufarfakhurtdinov.client.model.TaskList;

import static jetbrains.jetpad.mapper.Synchronizers.forObservableRole;

/**
 * Created by dr on 06.04.2014.
 */
public class BoardMapper extends Mapper<Board, BoardView> {
    public BoardMapper(Board source) {
        super(source, new BoardView());

        getTarget().addNew.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TaskList taskList = new TaskList();
                taskList.name.set("new tasklist" + ++counter);
                getSource().items.add(taskList);
            }
        } );
    }

    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers(conf);
        conf.add(forObservableRole(this, getSource().items, new WidgetChildList( getTarget().main ), new MapperFactory<TaskList, Widget>() {
            @Override
            public Mapper<? extends TaskList, ? extends Widget> createMapper(TaskList source) {
                return new TaskListMapper(source);
            }
        }));
    }

    private static int counter = 0;
}