package zufarfakhurtdinov.client.model;

import jetbrains.jetpad.model.children.HasParent;
import jetbrains.jetpad.model.property.Property;
import jetbrains.jetpad.model.property.ValueProperty;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItem extends HasParent<TaskList, TaskListItem> {
    public final Property<String> text = new ValueProperty<>("");
}
