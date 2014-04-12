package zufarfakhurtdinov.client.mapper.tasklist;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.MapperFactory;
import jetbrains.jetpad.mapper.Synchronizers;
import jetbrains.jetpad.model.property.WritableProperty;
import zufarfakhurtdinov.client.common.WidgetChildList;
import zufarfakhurtdinov.client.mapper.taskitem.TaskListItemMapper;
import zufarfakhurtdinov.client.model.TaskList;
import zufarfakhurtdinov.client.model.TaskListItem;

import static jetbrains.jetpad.mapper.Synchronizers.forObservableRole;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListMapper extends Mapper<TaskList, TaskListView> {
    public TaskListMapper(TaskList source) {
        super(source, new TaskListView());

        getTarget().addNew.addClickHandler( new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String text = "new task";
                TaskListItem item = new TaskListItem();
                item.text.set(text);
                getSource().items.add(item);
            }
        });
        getTarget().delete.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getSource().removeFromParent();
            }
        });
    }


    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers( conf );

        conf.add(forObservableRole(this, getSource().items, new WidgetChildList(getTarget().children), new MapperFactory<TaskListItem, Widget>() {
            @Override
            public Mapper<? extends TaskListItem, ? extends Widget> createMapper(TaskListItem source) {
                return new TaskListItemMapper(source);
            }
        }));

        conf.add(Synchronizers.forProperty(getSource().name, new WritableProperty<String>() {
            @Override
            public void set(String s) {
                getTarget().name.setInnerText( s );
            }
        }));
    }
}
