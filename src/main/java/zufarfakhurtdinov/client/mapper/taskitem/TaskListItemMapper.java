package zufarfakhurtdinov.client.mapper.taskitem;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Widget;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.Synchronizers;
import jetbrains.jetpad.model.collections.list.ObservableList;
import zufarfakhurtdinov.client.common.InplaceEditor;
import zufarfakhurtdinov.client.mapper.viewmodel.TaskListViewModel;
import zufarfakhurtdinov.client.model.TaskListItem;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemMapper extends Mapper<TaskListItem, TaskListItemView> {
    private static final String TRANSFER_DATA_TYPE = "transferDateType";
    private static final String AFTER_DROP_COLOR = "afterDropColor";
    private static final String TRANSITION_DROP = "transitionDrop";

    private static TaskListItem ourDraggedItem;
    private final TaskListViewModel taskListViewModel;

    public TaskListItemMapper( TaskListItem source, final TaskListViewModel taskListViewModel) {
        super(source, new TaskListItemView());

        this.taskListViewModel = taskListViewModel;
        if( taskListViewModel.droppedTaskId.get() != null && source.id == taskListViewModel.droppedTaskId.get()) {
            highlightTemporarily(getTarget().textPanel);
            taskListViewModel.droppedTaskId.set(null);
        }
        getTarget().delete.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getSource().removeFromParent();
            }
        });

        getTarget().textPanel.getElement().setDraggable(Element.DRAGGABLE_TRUE);
        getTarget().textPanel.addDomHandler(new DragStartHandler() {
            @Override
            public void onDragStart(DragStartEvent event) {
                event.getDataTransfer().setData(TRANSFER_DATA_TYPE, "");
                event.getDataTransfer().setDragImage(getTarget().main.getElement(), 10, 10);
                ourDraggedItem = getSource();
            }
        }, DragStartEvent.getType());

        getTarget().main.sinkBitlessEvent(DragOverEvent.getType().getName());

//        getTarget().main.addDomHandler(new DragEnterHandler() {
//            @Override
//            public void onDragEnter(DragEnterEvent event) {
//                getTarget().textPanel.addStyleName(AFTER_DROP_COLOR);
//            }
//        }, DragEnterEvent.getType());
        getTarget().main.addDomHandler(new DropHandler() {
            @Override
            public void onDrop(DropEvent event) {
                event.preventDefault();
                event.stopPropagation();
                if (ourDraggedItem == null) {
                    return;
                }
                ObservableList<TaskListItem> taskLists = getSource().parent().get().items;

                int indexToAdd = taskLists.indexOf(getSource());
                ourDraggedItem.removeFromParent();
                taskListViewModel.droppedTaskId.set( ourDraggedItem.id );
                taskLists.add(indexToAdd, ourDraggedItem);
                ourDraggedItem = null;
            }
        }, DropEvent.getType());
    }

    private static void highlightTemporarily(final Widget widget) {
        widget.addStyleName(AFTER_DROP_COLOR);

        Scheduler.get().scheduleDeferred( new Command() {
            @Override
            public void execute() {
                widget.removeStyleName(AFTER_DROP_COLOR);
                widget.addStyleName(TRANSITION_DROP);
                Scheduler.get().scheduleDeferred(new Command() {
                    @Override
                    public void execute() {
                        widget.removeStyleName(TRANSITION_DROP);
                    }
                });
            }
        });
    }

    private static native void click(Element element)/*-{
        element.click();
    }-*/;

    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers(conf);
        conf.add(Synchronizers.forProperties(getSource().text,
                InplaceEditor.editableTextOf(getTarget().text, getTarget().textPanel, getTarget().textEdit))
        );
        conf.add(Synchronizers.forProperty( taskListViewModel.lastUserAddedTaskId, new Runnable() {
            @Override
            public void run() {
                if( taskListViewModel.lastUserAddedTaskId.get() == null ) {
                    return;
                }
                if( taskListViewModel.lastUserAddedTaskId.get() == getSource().id ) {
                    showNameEdit();
//                    taskListViewModel.lastUserAddedTaskId.set( null );
                }
            }
        }));
    }

    private void showNameEdit() {
        click( getTarget().text.getElement() );
    }
}