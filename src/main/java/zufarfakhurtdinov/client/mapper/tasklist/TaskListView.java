package zufarfakhurtdinov.client.mapper.tasklist;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import jetbrains.jetpad.mapper.gwt.BaseWithElement;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListView extends BaseWithElement {

    public TaskListView() {
        setElement( ourUiBinder.createAndBindUi( this ) );
    }

    @UiField
    SpanElement name;

    @UiField
    UListElement children;

    @UiField
    ButtonElement addNew;

    interface TaskListViewUiBinder extends UiBinder<DivElement, TaskListView>{}
    private static final TaskListViewUiBinder ourUiBinder = GWT.create( TaskListViewUiBinder.class );
}
