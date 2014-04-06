package zufarfakhurtdinov.client.mapper.board;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import jetbrains.jetpad.mapper.gwt.BaseWithElement;

/**
 * Created by dr on 06.04.2014.
 */
public class BoardView extends BaseWithElement {

    public BoardView() {
        setElement( ourUiBinder.createAndBindUi( this ) );
    }

    @UiField
    DivElement main;
    @UiField
    ButtonElement addNew;


    interface BoardUiBinder extends UiBinder<DivElement, BoardView>{}
    private static final BoardUiBinder ourUiBinder = GWT.create( BoardUiBinder.class );

}
