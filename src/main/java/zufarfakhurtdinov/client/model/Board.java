package zufarfakhurtdinov.client.model;

import jetbrains.jetpad.model.children.ChildList;
import jetbrains.jetpad.model.collections.list.ObservableList;

/**
 * Created by dr on 06.04.2014.
 */
public class Board {
    public final ObservableList<TaskList> items = new ChildList<>(this);
}
