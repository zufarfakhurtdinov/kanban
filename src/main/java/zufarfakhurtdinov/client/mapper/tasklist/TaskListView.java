package zufarfakhurtdinov.client.mapper.tasklist;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import org.gwtbootstrap3.client.ui.Button;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListView extends Composite {

    public TaskListView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiField
    Label name;

    @UiField
    Button addNew;
    @UiField
    Button delete;
    @UiField
    FlowPanel children;
    @UiField
    HTMLPanel main;
    @UiField
    FlowPanel title;

    interface TaskListViewUiBinder extends UiBinder<Widget, TaskListView>{}
    private static final TaskListViewUiBinder ourUiBinder = GWT.create( TaskListViewUiBinder.class );
}
