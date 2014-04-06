package zufarfakhurtdinov.client.mapper;

import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.MapperFactory;
import jetbrains.jetpad.mapper.Synchronizers;
import jetbrains.jetpad.mapper.gwt.WithElement;
import zufarfakhurtdinov.client.model.TaskListItem;
import zufarfakhurtdinov.client.view.TaskListItemView;

import static jetbrains.jetpad.mapper.Synchronizers.forObservableRole;
import static jetbrains.jetpad.mapper.Synchronizers.forProperty;
import static jetbrains.jetpad.mapper.gwt.DomUtil.*;
import static jetbrains.jetpad.mapper.gwt.DomUtil.hasClass;
import static jetbrains.jetpad.model.property.Properties.size;
import static jetbrains.jetpad.model.property.Properties.toStringOf;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemMapper extends Mapper<TaskListItem, TaskListItemView> {
    public TaskListItemMapper(TaskListItem source ) {
        super(source, new TaskListItemView());
    }


    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers(conf);
        conf.add(Synchronizers.forProperties(getSource().text, editableTextOf(getTarget().text)));

//        conf.add(Synchronizers.forProperties(getSource().completed, checkbox(getTarget().checkbox)));
//        conf.add(forProperty(getSource().completed, hasClass(getTarget().text, "completed")));
    }
}
