package zufarfakhurtdinov.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import zufarfakhurtdinov.client.logic.impl.AbstractMainView;

/**
 * Created by dr on 30.03.2014.
 */
public class MainView extends Composite implements AbstractMainView{

    public MainView() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }

    @UiField
    Button testButton;

    static MainUiBinder uiBinder = GWT.create( MainUiBinder.class );
    interface MainUiBinder extends UiBinder<Widget, MainView> {}
}
