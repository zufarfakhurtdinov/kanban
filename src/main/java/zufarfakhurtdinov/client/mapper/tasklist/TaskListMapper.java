package zufarfakhurtdinov.client.mapper.tasklist;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.Widget;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.MapperFactory;
import jetbrains.jetpad.mapper.Synchronizers;
import jetbrains.jetpad.model.collections.list.ObservableList;
import zufarfakhurtdinov.client.common.InplaceEditor;
import zufarfakhurtdinov.client.common.WidgetChildList;
import zufarfakhurtdinov.client.mapper.viewmodel.TaskListViewModel;
import zufarfakhurtdinov.client.mapper.taskitem.TaskListItemMapper;
import zufarfakhurtdinov.client.model.TaskList;
import zufarfakhurtdinov.client.model.TaskListItem;

import static jetbrains.jetpad.mapper.Synchronizers.forObservableRole;

/**
 * Created by dr on 05.04.2014.
 */
public class TaskListMapper extends Mapper<TaskList, TaskListView> {
    private static final String TRANSFER_DATA_TYPE = "transferDateType";
    private static TaskList ourDraggedTaskList;
    private final TaskListViewModel taskListViewModel;

    public TaskListMapper(TaskList source, final TaskListViewModel taskListViewModel) {
        super(source, new TaskListView());

        this.taskListViewModel = taskListViewModel;

        getTarget().addTask.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String text = "new task";
                TaskListItem item = new TaskListItem();
                item.text.set(text);
                getSource().items.add(item);

                taskListViewModel.lastUserAddedTaskId.set( item.id );
            }
        });
        getTarget().delete.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getSource().removeFromParent();
            }
        });

        getTarget().namePanel.getElement().setDraggable( Element.DRAGGABLE_TRUE );
        getTarget().namePanel.addDomHandler( new DragStartHandler() {
            @Override
            public void onDragStart(DragStartEvent event) {
                event.getDataTransfer().setData(TRANSFER_DATA_TYPE, "");
                ourDraggedTaskList = getSource();
                event.getDataTransfer().setDragImage(getTarget().main.getElement(), 10, 10);
            }
        },DragStartEvent.getType());

        getTarget().main.sinkBitlessEvent( DragOverEvent.getType().getName());
        getTarget().main.addDomHandler( new DropHandler() {
            @Override
            public void onDrop(DropEvent event) {
                event.preventDefault();
                event.stopPropagation();

                if( ourDraggedTaskList == null ) {
                    return;
                }

                ObservableList<TaskList> taskLists = getSource().parent().get().items;

                int indexToAdd = taskLists.indexOf(getSource());
                ourDraggedTaskList.removeFromParent();
                taskLists.add( indexToAdd, ourDraggedTaskList);
                ourDraggedTaskList = null;
            }
        }, DropEvent.getType() );
    }

    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers( conf );

        conf.add(forObservableRole(this, getSource().items, new WidgetChildList(getTarget().children), new MapperFactory<TaskListItem, Widget>() {
            @Override
            public Mapper<? extends TaskListItem, ? extends Widget> createMapper(TaskListItem source) {
                return new TaskListItemMapper(source, taskListViewModel);
            }
        }));

        conf.add(Synchronizers.forProperties(getSource().name,
                InplaceEditor.editableTextOf( getTarget().name, getTarget().namePanel, getTarget().editName) )
        );
    }
}
