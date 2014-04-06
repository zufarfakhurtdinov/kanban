package zufarfakhurtdinov.client.mapper.tasklist;

import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.Event;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.MapperFactory;
import jetbrains.jetpad.mapper.Synchronizers;
import jetbrains.jetpad.mapper.gwt.WithElement;
import zufarfakhurtdinov.client.mapper.taskitem.TaskListItemMapper;
import zufarfakhurtdinov.client.model.TaskList;
import zufarfakhurtdinov.client.model.TaskListItem;

import static com.google.gwt.query.client.GQuery.$;
import static jetbrains.jetpad.mapper.Synchronizers.forObservableRole;
import static jetbrains.jetpad.mapper.gwt.DomUtil.editableTextOf;
import static jetbrains.jetpad.mapper.gwt.DomUtil.withElementChildren;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListMapper extends Mapper<TaskList, TaskListView> {
    public TaskListMapper(TaskList source) {
        super(source, new TaskListView());

        $(getTarget().addNew).click(new Function() {
            @Override
            public boolean f(Event e) {
                String text = "new task";
                TaskListItem item = new TaskListItem();
                item.text.set(text);
                getSource().items.add(item);
                return false;
            }
        });
    }


    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers( conf );

        conf.add(forObservableRole(this, getSource().items, withElementChildren(getTarget().children), new MapperFactory<TaskListItem, WithElement>() {
            @Override
            public Mapper<? extends TaskListItem, ? extends WithElement> createMapper(TaskListItem source) {
                return new TaskListItemMapper(source);
            }
        }));

        conf.add(Synchronizers.forProperties(getSource().name, editableTextOf(getTarget().name)));
    }
}
