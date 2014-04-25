package zufarfakhurtdinov.client.mapper.taskitem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.TextBox;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemView extends Composite {

    private static final TaskListItemUiBinder ourUiBinder = GWT.create( TaskListItemUiBinder.class);
    @UiField
    Label text;
    @UiField
    Button delete;
    @UiField
    HTMLPanel main;
    @UiField
    HTMLPanel textPanel;
    @UiField
    TextBox textEdit;

    public TaskListItemView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
    interface TaskListItemUiBinder extends UiBinder<Widget, TaskListItemView > {}
}
