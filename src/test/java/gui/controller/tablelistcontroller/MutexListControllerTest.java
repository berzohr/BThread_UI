package gui.controller.tablelistcontroller;

import gui.model.date.Mutex;
import gui.model.date.datamodel.MutexModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class MutexListControllerTest {


    private ObservableList<Mutex> mutexObservableList;
    private MutexModel mutexModel;
    private MutexListController mutexListController;

    @Before
    public void setUp() {
        mutexObservableList = FXCollections.observableArrayList(new ArrayList<>());
        mutexModel = MutexModel.create(mutexObservableList);
        mutexListController = Mockito.spy(MutexListController.create(mutexModel));
        Mockito.doNothing().when(mutexListController).reloadData();
    }

    @Test
    public void create01() {
        assertNull(MutexListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(mutexListController);
    }

    @Test
    public void controll01() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 3 0x10282e0b0");
        mutexListController.controll(mutex);
        assertEquals(1, mutexModel.listSize());
    }

    @Test
    public void controll02() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 3 0x10282e0b0");
        mutexListController.controll(mutex);
        Mutex mutex1 = Mutex.create(("(MUTRELEASE) 3 0x10282e0b0"));
        mutexListController.mutreleaseFunction(mutex1);
        assertEquals(0, mutexModel.listSize());
    }

    @Test
    public void mutacquireFunction01() {
        Mutex mutex = Mockito.mock(Mutex.class);
        mutexListController = Mockito.mock(MutexListController.class);
        mutexListController.mutacuireFunction(mutex);
        Mockito.verify(mutexListController, Mockito.times(1)).mutacuireFunction(mutex);
    }

    @Test
    public void mutacquireFunction02() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 3 0x10282e0b0");
        mutexListController.mutacuireFunction(mutex);
        Mutex mutex1 = Mutex.create("(MUTACQUIRE) 5 0x10282e0b0");
        mutexListController.mutacuireFunction(mutex1);
       assertEquals("5", mutexModel.getElementByIndex(0).getQueue());
    }

    @Test
    public void mutreleaseFunction() {
        Mutex mutex = Mockito.mock(Mutex.class);
        mutexListController = Mockito.mock(MutexListController.class);
        mutexListController.mutreleaseFunction(mutex);
        Mockito.verify(mutexListController, Mockito.times(1)).mutreleaseFunction(mutex);
    }
}