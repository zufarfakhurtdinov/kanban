package zufarfakhurtdinov.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import jetbrains.jetpad.mapper.gwt.BaseWithElement;
import zufarfakhurtdinov.client.model.TaskListItem;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemView extends BaseWithElement {

    public TaskListItemView() {
        setElement(ourUiBinder.createAndBindUi(this));
    }

    @UiField
    public SpanElement text;
    @UiField
    AnchorElement delete;
    @UiField
    InputElement checkbox;

    private static final TaskListItemUiBinder ourUiBinder = GWT.create( TaskListItemUiBinder.class);
    interface TaskListItemUiBinder extends UiBinder<LIElement, TaskListItemView > {}
}
