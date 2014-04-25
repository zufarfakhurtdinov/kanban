package zufarfakhurtdinov.client.mapper.viewmodel;

import jetbrains.jetpad.model.property.Property;
import jetbrains.jetpad.model.property.ValueProperty;

/**
 * Created by dr on 22.04.2014.
 */
public class TaskListViewModel {
    public final Property<Integer> lastUserAddedTaskId = new ValueProperty<>();
    public final Property<Integer> droppedTaskId = new ValueProperty<>();

}
