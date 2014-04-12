package zufarfakhurtdinov.client.mapper.taskitem;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.Synchronizers;
import jetbrains.jetpad.model.property.WritableProperty;
import zufarfakhurtdinov.client.model.TaskListItem;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemMapper extends Mapper<TaskListItem, TaskListItemView> {
    public TaskListItemMapper( TaskListItem source ) {
        super(source, new TaskListItemView());

        getTarget().delete.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getSource().removeFromParent();
            }
        });
        //TODO: implement behaviour for initial data
//        Scheduler.get().scheduleDeferred(new Command() {
//            @Override
//            public void execute() {
//                $(getTarget().text).click();
//            }
//        });

    }

    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers(conf);
        conf.add(Synchronizers.forProperty(getSource().text, new WritableProperty<String>() {
            @Override
            public void set(String s) {
                getTarget().text.setInnerText(s);
            }
        }));
    }

}