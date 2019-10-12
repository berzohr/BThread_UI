package gui.controller.tablelistcontroller;

import gui.model.date.Semaphore;
import gui.model.date.datamodel.SemaphoreModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SemaphoreListControllerTest {

    private ObservableList<Semaphore> semaphoreObservableList;
    private SemaphoreModel semaphoreModel;
    private SemaphoreListController semaphoreListController;

    @Before
    public void setUp() {
        semaphoreObservableList = FXCollections.observableArrayList(new ArrayList());
        semaphoreModel = SemaphoreModel.create(semaphoreObservableList);
        semaphoreListController = Mockito.spy(SemaphoreListController.create(semaphoreModel));
        Mockito.doNothing().when(semaphoreListController).reloadData();
    }

    @Test
    public void create01() {
        semaphoreListController = SemaphoreListController.create(null);
        assertNull(semaphoreListController);
    }

    @Test
    public void create02() {
        assertNotNull(semaphoreListController);
    }

    @Test
    public void controll01() {
        Semaphore semaphore = Semaphore.create("(SEMWAIT) 2 0x1077dc0d0 0");
        semaphoreListController.controll(semaphore);
        Mockito.verify(semaphoreListController, Mockito.times(1)).sewaitFunction(semaphore);
    }

    @Test
    public void controll02() {
        Semaphore semaphore = Semaphore.create("(SEMACQUIRE) 2 0x1077dc0d0 0");
        semaphoreListController.controll(semaphore);
        Mockito.verify(semaphoreListController, Mockito.times(1)).semacquireFunction(semaphore);
    }

    @Test
    public void controll03() {
        Semaphore semaphore = Semaphore.create("(SEMPOST) 2 0x1077dc0d0 0");
        semaphoreListController.controll(semaphore);
        Mockito.verify(semaphoreListController, Mockito.times(1)).sempostFunction(semaphore);
    }


    @Test
    public void sewaitFunction01() {
        Semaphore semaphore = Semaphore.create("(SEMWAIT) 2 0x1077dc0d0 0");
        semaphoreListController.sewaitFunction(semaphore);
        assertEquals(1, semaphoreModel.listSize());
        assertEquals("2", semaphoreModel.getElementByIndex(0).getQueue());
    }

    @Test
    public void sewaitFunction02() {
        Semaphore semaphore1 = Semaphore.create("(SEMWAIT) 2 0x1077dc0d0 0");
        semaphoreListController.sewaitFunction(semaphore1);
        assertEquals(1, semaphoreModel.listSize());
        assertEquals("2", semaphoreModel.getElementByIndex(0).getQueue());

        Semaphore semaphore2 = Semaphore.create("(SEMWAIT) 3 0x1077dc0d0 0");
        semaphoreListController.sewaitFunction(semaphore2);
        assertEquals(1, semaphoreModel.listSize());
        assertEquals("2 , 3", semaphoreModel.getElementByIndex(0).getQueue());
    }

    @Test
    public void semwaitFunction03() {
        Semaphore semaphore = Semaphore.create("(SEMWAIT) 1 0x102e960b8 1");
        semaphoreListController.sewaitFunction(semaphore);
        assertEquals("", semaphoreModel.getElementByIndex(0).getQueue());
    }

    @Test
    public void semacquireFunction01() {
        Semaphore semaphore1 = Semaphore.create("(SEMWAIT) 1 0x102e960b8 1");
        semaphore1.setQueue("1");
        semaphoreListController.sewaitFunction(semaphore1);
        assertEquals(1, semaphoreModel.listSize());
        assertEquals(1, semaphoreModel.getElementByIndex(0).getCounter());

        Semaphore semaphore2 = Semaphore.create("(SEMACQUIRE) 1 0x102e960b8 0");
        semaphoreListController.semacquireFunction(semaphore2);
        assertEquals(1, semaphoreModel.listSize());
        assertEquals(0, semaphoreModel.getElementByIndex(0).getCounter());
    }

    @Test
    public void sempostFunction01() {
        Semaphore semaphore = Semaphore.create("(SEMPOST) 2 0x102e960b8 0");
        semaphoreListController.sempostFunction(semaphore);
        assertEquals(1, semaphoreModel.getElementByIndex(0).getCounter());
    }

    @Test
    public void sempostFunction02() {
        Semaphore semaphore1 = Semaphore.create("(SEMWAIT) 2 0x1077dc0d0 0");
        semaphoreListController.sewaitFunction(semaphore1);
        assertEquals(1, semaphoreModel.listSize());
        assertEquals(0, semaphoreModel.getElementByIndex(0).getCounter());

        Semaphore semaphore2 = Semaphore.create("(SEMPOST) 3 0x1077dc0d0 0");
        semaphoreListController.sempostFunction(semaphore2);
        assertEquals(1, semaphoreModel.listSize());
        assertEquals(1, semaphoreModel.getElementByIndex(0).getCounter());
    }
}