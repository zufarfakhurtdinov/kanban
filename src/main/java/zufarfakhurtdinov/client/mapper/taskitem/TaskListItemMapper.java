package zufarfakhurtdinov.client.mapper.taskitem;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.*;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.Synchronizers;
import jetbrains.jetpad.model.collections.list.ObservableList;
import zufarfakhurtdinov.client.common.InplaceEditor;
import zufarfakhurtdinov.client.model.TaskListItem;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemMapper extends Mapper<TaskListItem, TaskListItemView> {
    public TaskListItemMapper( TaskListItem source ) {
        super(source, new TaskListItemView());

        getTarget().delete.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getSource().removeFromParent();
            }
        });

        getTarget().main.getElement().setDraggable(Element.DRAGGABLE_TRUE);
        getTarget().main.addDomHandler(new DragStartHandler() {
            @Override
            public void onDragStart(DragStartEvent event) {
                event.getDataTransfer().setData(TRANSFER_DATA_TYPE, "");
                event.getDataTransfer().setDragImage(getTarget().main.getElement(), 10, 10);
                draggedItem = getSource();
            }
        }, DragStartEvent.getType());

        getTarget().main.sinkBitlessEvent( DragOverEvent.getType().getName());
        getTarget().main.addDomHandler( new DropHandler() {
            @Override
            public void onDrop(DropEvent event) {
                event.preventDefault();
                event.stopPropagation();
                if (draggedItem == null) {
                    return;
                }
                ObservableList<TaskListItem> taskLists = getSource().parent().get().items;

                int indexToAdd = taskLists.indexOf(getSource());
                draggedItem.removeFromParent();
                taskLists.add( indexToAdd, draggedItem );
            }
        }, DropEvent.getType() );
    }

    public void showNameEdit() {
        click( getTarget().text.getElement() );
    }

    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers(conf);
        conf.add(Synchronizers.forProperty(getSource().text,
                InplaceEditor.editableTextOf(getTarget().text, getTarget().textPanel, getTarget().textEdit))
        );
    }

    private static native void click(Element element)/*-{
        element.click();
    }-*/;

    private static TaskListItem draggedItem;
    private static final String TRANSFER_DATA_TYPE = "transferDateType";
}