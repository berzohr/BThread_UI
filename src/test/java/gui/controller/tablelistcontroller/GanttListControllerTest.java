package gui.controller.tablelistcontroller;

import gui.model.date.Gantt;
import gui.model.date.datamodel.GanttModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GanttListControllerTest {

    private ObservableList<Gantt> ganttObservableList;
    private GanttModel ganttModel;
    private GanttListController ganttListController;

    @BeforeEach
    public void setUp() {
        ganttObservableList = FXCollections.observableArrayList(new ArrayList<>());
        ganttModel = Mockito.spy(GanttModel.create(ganttObservableList));
        ganttListController = Mockito.spy(GanttListController.create(ganttModel));
    }

    @Test
    public void create01() {
        assertNull(GanttListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(ganttListController);
    }

    @Test
    public void controll() {
        Gantt gantt = Gantt.create("(CREATE) 1");
        ganttListController.controll(gantt);
        Mockito.verify(ganttListController, Mockito.times(1)).addElementToStatusList(gantt);
    }

    @Test
    public void updateValueList() {
        Gantt gantt1 = Gantt.create("(CREATE) 1");
        ganttListController.controll(gantt1);

        Gantt gantt2 = Gantt.create("(SCHEDULING) 1");
        ganttListController.controll(gantt2);
        Mockito.verify(ganttListController, Mockito.times(1)).updateValueList(gantt2, gantt2.getStatus());
    }

    @Test
    public void addElementToStatusList() {
        Gantt gantt = Gantt.create("(CREATE) 1");
        ganttListController.controll(gantt);
        Mockito.verify(ganttModel, Mockito.times(1)).addElement(gantt);
    }
}