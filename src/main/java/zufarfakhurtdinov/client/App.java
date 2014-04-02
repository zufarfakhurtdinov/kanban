package zufarfakhurtdinov.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Created by dr on 30.03.2014.
 */
public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {
        MyFactory myFactory = MyFactory.INSTANCE;

        myFactory.getEventBus();

        RootPanel.get().add( myFactory.getMainView() );

    }
}
