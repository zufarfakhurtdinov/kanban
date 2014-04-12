package zufarfakhurtdinov.client.mapper.tasklist;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.Button;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListView extends Composite {

    public TaskListView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiField
    SpanElement name;

    @UiField
    Button addNew;
    @UiField
    Button delete;
    @UiField
    FlowPanel children;
    @UiField
    HTMLPanel main;
    @UiField
    HTMLPanel title;

    interface TaskListViewUiBinder extends UiBinder<Widget, TaskListView>{}
    private static final TaskListViewUiBinder ourUiBinder = GWT.create( TaskListViewUiBinder.class );
}
