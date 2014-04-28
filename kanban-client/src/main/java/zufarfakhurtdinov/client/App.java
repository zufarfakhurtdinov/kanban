package zufarfakhurtdinov.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import jetbrains.jetpad.mapper.Mapper;
import zufarfakhurtdinov.client.mapper.board.BoardMapper;
import zufarfakhurtdinov.client.model.Board;
import zufarfakhurtdinov.client.model.TaskList;
import zufarfakhurtdinov.client.model.TaskListItem;

/**
 * Created by dr on 30.03.2014.
 */
public class App implements EntryPoint {

    private static Board createBoard() {
        Board board = new Board();
        board.items.add( createTaskList() );
        return board;
    }

    private static TaskList createTaskList() {
        TaskList taskList = new TaskList();
        taskList.name.set("taskList1");
        taskList.items.add(createTaskListItem( "text1" ) );
        taskList.items.add(createTaskListItem( "text2" ) );
        taskList.items.add(createTaskListItem( "text3" ) );
        taskList.items.add(createTaskListItem( "text4" ) );
        return taskList;
    }

    private static TaskListItem createTaskListItem(String text) {
        TaskListItem item = new TaskListItem();
        item.text.set(text);
        return item;
    }

    @Override
    public void onModuleLoad() {
        Board board = createBoard();
        Mapper<Board, ? extends Widget> mapper = new BoardMapper( board );
        mapper.attachRoot();

        RootPanel.get().add( mapper.getTarget() );
    }
}
