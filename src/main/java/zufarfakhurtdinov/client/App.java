package zufarfakhurtdinov.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.gwt.WithElement;
import zufarfakhurtdinov.client.mapper.TaskListMapper;
import zufarfakhurtdinov.client.model.TaskList;
import zufarfakhurtdinov.client.model.TaskListItem;

/**
 * Created by dr on 30.03.2014.
 */
public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {
        MyFactory myFactory = MyFactory.INSTANCE;

        myFactory.getEventBus();

        TaskList taskList = createTaskList();

        Mapper<TaskList, ? extends WithElement> mapper = new TaskListMapper( taskList );
        mapper.attachRoot();

        Document.get().getElementById("main").appendChild( mapper.getTarget().getElement());
    }

    private static TaskList createTaskList() {
        TaskList taskList = new TaskList();
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
}
