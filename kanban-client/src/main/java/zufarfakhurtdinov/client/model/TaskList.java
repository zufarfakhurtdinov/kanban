package zufarfakhurtdinov.client.model;

import jetbrains.jetpad.model.children.ChildList;
import jetbrains.jetpad.model.children.HasParent;
import jetbrains.jetpad.model.collections.list.ObservableList;
import jetbrains.jetpad.model.property.Property;
import jetbrains.jetpad.model.property.ValueProperty;

import java.util.UUID;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskList extends HasParent<Board, TaskList> {
    public final ObservableList<TaskListItem> items = new ChildList<>(this);
    public final Property<String> name = new ValueProperty<>("");
    public final String id;


    public TaskList(String id) {
        this.id = id;
    }
}
