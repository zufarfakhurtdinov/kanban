package zufarfakhurtdinov.client.mapper.board;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import jetbrains.jetpad.mapper.Mapper;
import jetbrains.jetpad.mapper.MapperFactory;
import zufarfakhurtdinov.client.common.IdFactory;
import zufarfakhurtdinov.client.common.WidgetChildList;
import zufarfakhurtdinov.client.mapper.viewmodel.BoardViewModel;
import zufarfakhurtdinov.client.mapper.tasklist.TaskListMapper;
import zufarfakhurtdinov.client.model.Board;
import zufarfakhurtdinov.client.model.TaskList;

import static jetbrains.jetpad.mapper.Synchronizers.forObservableRole;

public class BoardMapper extends Mapper<Board, BoardView> {
    private final IdFactory ID_FACTORY;
    private final BoardViewModel viewModel = new BoardViewModel();

    public BoardMapper(Board source, IdFactory idFactory) {
        super(source, new BoardView());
        this.ID_FACTORY = idFactory;
        getTarget().addNew.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TaskList taskList = new TaskList(ID_FACTORY.getId());
                taskList.name.set("new tasklist " + taskList.id);
                getSource().items.add(taskList);
            }
        });
    }

    @Override
    protected void registerSynchronizers(SynchronizersConfiguration conf) {
        super.registerSynchronizers(conf);
        conf.add(forObservableRole(this, getSource().items, new WidgetChildList( getTarget().main ), new MapperFactory<TaskList, Widget>() {
            @Override
            public Mapper<? extends TaskList, ? extends Widget> createMapper(TaskList source) {
                return new TaskListMapper(source, viewModel, ID_FACTORY);
            }
        }));
    }
}