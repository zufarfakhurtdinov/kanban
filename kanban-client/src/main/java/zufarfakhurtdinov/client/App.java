package zufarfakhurtdinov.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import jetbrains.jetpad.mapper.Mapper;
import zufarfakhurtdinov.client.common.IdFactory;
import zufarfakhurtdinov.client.common.SimpleIdFactory;
import zufarfakhurtdinov.client.mapper.board.BoardMapper;
import zufarfakhurtdinov.client.model.Board;
import zufarfakhurtdinov.client.model.TaskList;
import zufarfakhurtdinov.client.model.TaskListItem;

public class App implements EntryPoint {

    private static final IdFactory ID_FACTORY = new SimpleIdFactory();

    private static Board createBoard() {
        Board board = new Board(ID_FACTORY.getId());
        board.items.add( createTaskList() );
        return board;
    }

    private static TaskList createTaskList() {
        TaskList taskList = new TaskList(ID_FACTORY.getId());
        taskList.name.set("taskList1");
        taskList.items.add(createTaskListItem( "text1" ) );
        taskList.items.add(createTaskListItem( "text2" ) );
        taskList.items.add(createTaskListItem( "text3" ) );
        taskList.items.add(createTaskListItem( "text4" ) );
        return taskList;
    }

    private static TaskListItem createTaskListItem(String text) {
        TaskListItem item = new TaskListItem(ID_FACTORY.getId());
        item.text.set(text);
        return item;
    }

    @Override
    public void onModuleLoad() {
        Board board = createBoard();
        Mapper<Board, ? extends Widget> mapper = new BoardMapper( board, ID_FACTORY );
        mapper.attachRoot();

        RootPanel.get().add( mapper.getTarget() );
    }
}
