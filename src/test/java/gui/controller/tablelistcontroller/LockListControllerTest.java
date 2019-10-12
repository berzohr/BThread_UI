package gui.controller.tablelistcontroller;

import gui.model.date.Lock;
import gui.model.date.datamodel.LockModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class LockListControllerTest {

    ObservableList<Lock> lockObservableList;
    LockModel lockModel;
    LockListController lockListController;

    @BeforeEach
    void setUp() {
        lockObservableList = FXCollections.observableArrayList(new ArrayList<>());
        lockModel = LockModel.create(lockObservableList);
        lockListController = Mockito.spy(LockListController.create(lockModel));
        Mockito.doNothing().when(lockListController).reloadData();
    }

    @Test
    public void create01() {
        assertNull(LockListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(lockListController);
    }

    @Test
    public void controll01() {
        LockModel lockModel = Mockito.mock(LockModel.class);
        Lock lock = Lock.create("(SCHEDULING) 5");
        LockListController.create(lockModel).controll(lock);
        Mockito.verify(lockModel, Mockito.times(1)).addElement(lock);
    }

    @Test
    public void controll02() {
        Lock lock = Lock.create("(SCHEDULING) 5");
        lockListController.controll(lock);
        assertEquals(null, lockModel.getElementByIndex(0).getStatus());
        Lock lock1 = Lock.create("(SCHEDULING) 5");
        lockListController.controll(lock1);
        assertEquals("LOCK", lockModel.getElementByIndex(0).getStatus());
    }

    @Test
    public void removeLockStatuFromElement01() {
        Lock lock = Lock.create("(SCHEDULING) 5");
        lock.setStatus("LOCK");
        lockModel.addElement(lock);
        assertEquals(5, lockModel.getElementByIndex(0).getThreadId());
        assertEquals("LOCK", lockModel.getElementByIndex(0).getStatus());
        lockListController.removeLockStatuFromElement();
        assertNull(lockModel.getElementByIndex(0).getStatus());
    }
}