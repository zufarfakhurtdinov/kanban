package zufarfakhurtdinov.client.mapper.board;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by dr on 06.04.2014.
 */
public class BoardView extends Composite {

    public BoardView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiField
    FlowPanel main;
    @UiField
    Button addNew;


    interface BoardUiBinder extends UiBinder<Widget, BoardView>{}
    private static final BoardUiBinder ourUiBinder = GWT.create( BoardUiBinder.class );

}
