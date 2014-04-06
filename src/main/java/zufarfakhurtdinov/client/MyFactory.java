package zufarfakhurtdinov.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created by dr on 30.03.2014.
 */
@GinModules( InjectorModule.class )
public interface MyFactory extends Ginjector{

    public static final MyFactory INSTANCE = GWT.create(MyFactory.class);

    public EventBus getEventBus();

//    public MainPresenter getMainPresenter();
//    public MainView getMainView();
}
