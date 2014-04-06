package zufarfakhurtdinov.client.mapper;

import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.MapperFactory;
import jetbrains.jetpad.mapper.gwt.WithElement;
import zufarfakhurtdinov.client.model.TaskList;
import zufarfakhurtdinov.client.model.TaskListItem;
import zufarfakhurtdinov.client.view.TaskListView;

import java.util.ArrayList;
import java.util.List;

import static com.google.gwt.query.client.GQuery.$;
import static jetbrains.jetpad.mapper.Synchronizers.forObservableRole;
import static jetbrains.jetpad.mapper.Synchronizers.forProperty;
import static jetbrains.jetpad.mapper.gwt.DomUtil.innerTextOf;
import static jetbrains.jetpad.mapper.gwt.DomUtil.withElementChildren;
import static jetbrains.jetpad.model.property.Properties.size;
import static jetbrains.jetpad.model.property.Properties.toStringOf;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListMapper extends Mapper<TaskList,TaskListView> {
    public TaskListMapper(TaskList source) {
        super(source, new TaskListView() );
    }


    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers(conf);

        conf.add(forObservableRole(this, getSource().items, withElementChildren( getTarget().children), new MapperFactory<TaskListItem, WithElement>() {
            @Override
            public Mapper<? extends TaskListItem, ? extends WithElement> createMapper(TaskListItem source) {
                return new TaskListItemMapper(source);
            }
        }));

        conf.add( forProperty( toStringOf( size( getSource().items ) ), innerTextOf( getTarget().count ) ) );
    }
}
