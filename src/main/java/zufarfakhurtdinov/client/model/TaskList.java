package zufarfakhurtdinov.client.model;

import jetbrains.jetpad.model.children.ChildList;
import jetbrains.jetpad.model.collections.list.ObservableList;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskList {
    public final ObservableList<TaskListItem> items = new ChildList<>(this);
}
