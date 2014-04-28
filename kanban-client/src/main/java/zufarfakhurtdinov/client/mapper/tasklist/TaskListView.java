package zufarfakhurtdinov.client.mapper.tasklist;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.PanelHeader;
import org.gwtbootstrap3.client.ui.TextBox;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListView extends Composite {

    private static final TaskListViewUiBinder ourUiBinder = GWT.create( TaskListViewUiBinder.class );
    @UiField
    Heading name;

    @UiField
    Button addTask;
    @UiField
    Button delete;
    @UiField
    FlowPanel children;
    @UiField
    SimplePanel main;
    @UiField
    PanelHeader title;
    @UiField
    TextBox editName;
    @UiField
    FlowPanel namePanel;

    public TaskListView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
    interface TaskListViewUiBinder extends UiBinder<Widget, TaskListView>{}
}
