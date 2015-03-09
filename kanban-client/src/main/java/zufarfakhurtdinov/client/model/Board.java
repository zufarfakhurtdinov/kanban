package zufarfakhurtdinov.client.model;

import jetbrains.jetpad.model.children.ChildList;
import jetbrains.jetpad.model.collections.list.ObservableList;

public class Board {
    public final String id;
    public final ObservableList<TaskList> items = new ChildList<>(this);

    public Board(String id) {
        this.id = id;
    }
}
