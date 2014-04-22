package zufarfakhurtdinov.client.model;

import jetbrains.jetpad.model.children.HasParent;
import jetbrains.jetpad.model.property.Property;
import jetbrains.jetpad.model.property.ValueProperty;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItem extends HasParent<TaskList, TaskListItem> {
    private static int ourCounter = 0;

    public final int id;
    public final Property<String> text = new ValueProperty<>("");

    public TaskListItem() {
        this(ourCounter++);
    }
    private TaskListItem(int id) {
        this.id = id;
    }
}
