package zufarfakhurtdinov.client.model;

import jetbrains.jetpad.model.children.HasParent;
import jetbrains.jetpad.model.property.Property;
import jetbrains.jetpad.model.property.ValueProperty;

public class TaskListItem extends HasParent<TaskList, TaskListItem> {
    public final String id;
    public final Property<String> text = new ValueProperty<>("");

    public TaskListItem(String id) {
        this.id = id;
    }
}
