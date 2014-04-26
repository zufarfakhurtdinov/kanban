package zufarfakhurtdinov.client.mapper.viewmodel;

import jetbrains.jetpad.model.property.Property;
import jetbrains.jetpad.model.property.ValueProperty;
import zufarfakhurtdinov.client.model.TaskListItem;

/**
 * Created by dr on 22.04.2014.
 */
public class BoardViewModel {
    public final Property<Integer> lastUserAddedTaskId = new ValueProperty<>();
    public final Property<TaskListItem> droppedTask = new ValueProperty<>();
    public TaskListItem draggedTask;
}
