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
import zufarfakhurtdinov.client.mapper.viewmodel.BoardViewModel;
import zufarfakhurtdinov.client.model.TaskListItem;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListItemMapper extends Mapper<TaskListItem, TaskListItemView> {
    private static final String TRANSFER_DATA_TYPE = "transferDateType";

    private static final String AFTER_DROP_COLOR = "afterDropColor";
    private static final String TRANSITION_DROP = "transitionDrop";
    private static final String DISABLE_POINTER_EVENTS = "disablePointerEvents";

    private static final String PLACE_TO_DROP = "placeToDrop";

    private final BoardViewModel boardViewModel;

    public TaskListItemMapper( TaskListItem source, final BoardViewModel boardViewModel) {
        super(source, new TaskListItemView());

        this.boardViewModel = boardViewModel;
        if( boardViewModel.droppedTask.get() != null && source.id == boardViewModel.droppedTask.get().id) {
            highlightTemporarily(getTarget().textPanel);
            boardViewModel.droppedTask.set(null);
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
                boardViewModel.draggedTask.set( getSource());
            }
        }, DragStartEvent.getType());

        getTarget().textPanel.addDomHandler( new DragOverHandler() {
            @Override
            public void onDragOver(DragOverEvent event) {
                event.stopPropagation();
                event.preventDefault();
                getTarget().textPanel.addStyleName(PLACE_TO_DROP);
            }
        }, DragOverEvent.getType());

        getTarget().textPanel.addDomHandler( new DragEnterHandler() {
            @Override
            public void onDragEnter(DragEnterEvent event) {
                event.stopPropagation();
                event.preventDefault();
                getTarget().textPanel.addStyleName(PLACE_TO_DROP);
            }
        }, DragEnterEvent.getType());

        getTarget().textPanel.addDomHandler( new DragLeaveHandler() {
            @Override
            public void onDragLeave(DragLeaveEvent event) {
                getTarget().textPanel.removeStyleName(PLACE_TO_DROP);
            }
        }, DragLeaveEvent.getType());


        getTarget().main.sinkBitlessEvent(DragOverEvent.getType().getName());
        getTarget().main.addDomHandler(new DropHandler() {
            @Override
            public void onDrop(DropEvent event) {
                event.preventDefault();
                event.stopPropagation();
                if (boardViewModel.draggedTask.get() == null) {
                    return;
                }
                ObservableList<TaskListItem> taskLists = getSource().parent().get().items;

                int indexToAdd = taskLists.indexOf(getSource());
                boardViewModel.draggedTask.get().removeFromParent();
                boardViewModel.droppedTask.set(boardViewModel.draggedTask.get());
                taskLists.add(indexToAdd, boardViewModel.draggedTask.get());
                boardViewModel.draggedTask.set(null);
                getTarget().textPanel.removeStyleName(PLACE_TO_DROP);
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
        conf.add(Synchronizers.forProperty( boardViewModel.lastUserAddedTaskId, new Runnable() {
            @Override
            public void run() {
                if( boardViewModel.lastUserAddedTaskId.get() == null ) {
                    return;
                }
                if( boardViewModel.lastUserAddedTaskId.get() == getSource().id ) {
                    showNameEdit();
//                    taskListViewModel.lastUserAddedTaskId.set( null );
                }
            }
        }));
        conf.add( Synchronizers.forProperty( boardViewModel.draggedTask, new Runnable() {
            @Override
            public void run() {
                if( boardViewModel.draggedTask.get() == null ) {
                    removeDisablePointerEvents();
                } else {
                    addDisablePointerEvents();
                }
            }
        }));
    }

    private void addDisablePointerEvents() {
        getTarget().text.addStyleName(DISABLE_POINTER_EVENTS);
        getTarget().delete.addStyleName(DISABLE_POINTER_EVENTS);
    }

    private void removeDisablePointerEvents() {
        getTarget().delete.removeStyleName(DISABLE_POINTER_EVENTS);
        getTarget().text.removeStyleName(DISABLE_POINTER_EVENTS);

    }
    private void showNameEdit() {
        click( getTarget().text.getElement() );
    }
}