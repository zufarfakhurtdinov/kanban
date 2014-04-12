package zufarfakhurtdinov.client.mapper.taskitem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.Button;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemView extends Composite {

    public TaskListItemView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiField
    SpanElement text;
    @UiField
    Button delete;
    @UiField
    InputElement input;

    private static final TaskListItemUiBinder ourUiBinder = GWT.create( TaskListItemUiBinder.class);
    interface TaskListItemUiBinder extends UiBinder<Widget, TaskListItemView > {}
}
