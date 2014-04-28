package zufarfakhurtdinov.client.common;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.AbstractList;

/**
 * Created by dr on 12.04.2014.
 */
public class WidgetChildList extends AbstractList<Widget>{

    private FlowPanel myParent;

    public WidgetChildList(FlowPanel myParent) {
        this.myParent = myParent;
    }

    @Override
    public void add(int index, Widget element) {
        myParent.insert(element, index);
    }

    @Override
    public Widget get(int index) {
        return myParent.getWidget( index );
    }

    @Override
    public int size() {
        return myParent.getWidgetCount();
    }

    @Override
    public Widget remove(int index) {
        Widget widget = myParent.getWidget(index);
        myParent.remove(index);
        return widget;
    }
}
