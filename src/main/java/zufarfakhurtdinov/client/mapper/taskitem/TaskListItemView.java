package zufarfakhurtdinov.client.mapper.taskitem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import jetbrains.jetpad.mapper.gwt.BaseWithElement;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemView extends BaseWithElement {

    public TaskListItemView() {
        setElement(ourUiBinder.createAndBindUi(this));
    }

    @UiField
    SpanElement text;
    @UiField
    ButtonElement delete;
    @UiField
    InputElement input;

    private static final TaskListItemUiBinder ourUiBinder = GWT.create( TaskListItemUiBinder.class);
    interface TaskListItemUiBinder extends UiBinder<LIElement, TaskListItemView > {}
}
