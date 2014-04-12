package zufarfakhurtdinov.client.common;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.AbstractList;

/**
 * Created by dr on 12.04.2014.
 */
public class WidgetChildList extends AbstractList<Widget>{

    public WidgetChildList(FlowPanel parent) {
        this.parent = parent;
    }

    @Override
    public void add(int index, Widget element) {
        parent.insert( element, index );
    }

    @Override
    public Widget get(int index) {
        return parent.getWidget( index );
    }

    @Override
    public int size() {
        return parent.getWidgetCount();
    }

    private FlowPanel parent;
}
