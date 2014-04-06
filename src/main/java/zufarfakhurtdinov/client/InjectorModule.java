package zufarfakhurtdinov.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;

import javax.inject.Singleton;

/**
 * Created by dr on 30.03.2014.
 */
public class InjectorModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind( EventBus.class ).to( SimpleEventBus.class ).in( Singleton.class );

//        bind( MainPresenter.class ).in( Singleton.class );
//        bind( AbstractMainView.class ).to(MainView.class).in( Singleton.class );
    }
}