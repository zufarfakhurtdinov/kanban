package zufarfakhurtdinov.client.mapper.taskitem;

import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.Event;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.Synchronizers;
import zufarfakhurtdinov.client.model.TaskListItem;

import static com.google.gwt.query.client.GQuery.$;
import static jetbrains.jetpad.mapper.gwt.DomUtil.editableTextOf;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemMapper extends Mapper<TaskListItem, TaskListItemView> {
    public TaskListItemMapper( TaskListItem source ) {
        super(source, new TaskListItemView());

        $(getTarget().delete).click( new Function() {
            @Override
            public boolean f( Event e ) {
                getSource().removeFromParent();
                return false;
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
        conf.add(Synchronizers.forProperties(getSource().text, editableTextOf(getTarget().text)));
    }
}