package zufarfakhurtdinov.client.mapper.board;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.Button;

/**
 * Created by dr on 06.04.2014.
 */
public class BoardView extends Composite {

    private static final BoardUiBinder ourUiBinder = GWT.create( BoardUiBinder.class );
    @UiField
    FlowPanel main;
    @UiField
    Button addNew;


    public BoardView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
    interface BoardUiBinder extends UiBinder<Widget, BoardView>{}

}
