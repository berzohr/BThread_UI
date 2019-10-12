package gui.controller.tablelistcontroller;

import gui.model.date.Status;
import gui.model.date.datamodel.StatusModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StatusListControllerTest {

    private ObservableList<Status> statusObservableList;
    private StatusModel statusModelmock;
    private StatusListController statusListController;


    @BeforeEach
    public void setUp() {
        statusObservableList = FXCollections.observableArrayList(new ArrayList<>());
        statusModelmock = Mockito.spy(StatusModel.create(statusObservableList));
        statusListController = Mockito.spy(StatusListController.create(statusModelmock));
        Mockito.doNothing().when(statusListController).reloadData();
    }

    @Test
    public void create01() {
        assertNull(StatusListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(statusListController);
    }

    @Test
    public void controll01() {
        Status status = Status.create("(CREATE) 1");
        statusListController.controll(status);
        Mockito.verify(statusModelmock, Mockito.times(1)).addElement(status);
    }

    @Test
    public void controll02() {
        Status status = Status.create("(READY) 1");
        statusListController.controll(status);
        Mockito.verify(statusListController, Mockito.times(1)).updateValueList(status, "READY");
    }

    @Test
    public void controll03() {
        Status status = Status.create("(SLEEPING) 1");
        statusListController.controll(status);
        Mockito.verify(statusListController, Mockito.times(1)).updateValueList(status, "SLEEPING");
    }

    @Test
    public void controll04() {
        Status status = Status.create("(BLOCKED) 1");
        statusListController.controll(status);
        Mockito.verify(statusListController, Mockito.times(1)).updateValueList(status, "BLOCKED");
    }

    @Test
    public void controll05() {
        Status status = Status.create("(EXIT) 1");
        statusListController.controll(status);
        Mockito.verify(statusListController, Mockito.times(1)).updateValueList(status, "EXIT");
    }

    @Test
    public void controll06() {
        Status status = Status.create("(SCHEDULING) 1");
        statusListController.controll(status);
        Mockito.verify(statusListController, Mockito.times(1)).updateValueList(status, "RUNNING");
    }

    @Test
    public void updateValueList() {
        Status status = Status.create("(CREATE) 1");
        statusListController.addElementToStatusList(status);
        assertEquals("CREATE", statusModelmock.getElementByIndex(0).getStatus());

        Status status1 = Status.create("(SCHEDULING) 1");
        statusListController.updateValueList(status1, "RUNNING");
        assertEquals("RUNNING", statusModelmock.getElementByIndex(0).getStatus());
    }

    @Test
    public void addElementToStatusList() {
        Status status = Status.create("(SCHEDULING) 1");
        statusListController.addElementToStatusList(status);
        Mockito.verify(statusModelmock, Mockito.times(1)).addElement(status);
    }
}