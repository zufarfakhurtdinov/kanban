package zufarfakhurtdinov.client.mapper.viewmodel;

import jetbrains.jetpad.model.property.Property;
import jetbrains.jetpad.model.property.ValueProperty;
import zufarfakhurtdinov.client.model.TaskListItem;

/**
 * Created by dr on 22.04.2014.
 */
public class TaskListViewModel {
    public final Property<TaskListItem> lastUserAddedTask = new ValueProperty<>();
}
