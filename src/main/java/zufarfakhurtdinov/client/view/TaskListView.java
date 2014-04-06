package zufarfakhurtdinov.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import jetbrains.jetpad.mapper.gwt.BaseWithElement;
import jetbrains.jetpad.mapper.gwt.WithElement;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListView extends BaseWithElement {

    public TaskListView() {
        setElement( ourUiBinder.createAndBindUi( this ) );
    }
    @UiField
    public UListElement children;
    @UiField
    public SpanElement count;
    @UiField
    public AnchorElement addNew;

    interface TaskListViewUiBinder extends UiBinder<DivElement, TaskListView>{}
    private static final TaskListViewUiBinder ourUiBinder = GWT.create( TaskListViewUiBinder.class );
}
