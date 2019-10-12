package gui.controller.tablelistcontroller;

import gui.model.date.Barrier;
import gui.model.date.datamodel.BarrierModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BarrierListControllerTest {

    private ObservableList<Barrier> barrierObservableList;
    private BarrierModel barrierModel;
    private BarrierListController barrierListController;


    @BeforeEach
    public void setUp() {
        barrierObservableList = FXCollections.observableArrayList(new ArrayList<>());
        barrierModel = BarrierModel.create(barrierObservableList);
        barrierListController = Mockito.spy(BarrierListController.create(barrierModel));
        Mockito.doNothing().when(barrierListController).reloadData();
    }

    @Test
    public void create01() {
        assertNull(BarrierListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(barrierListController);
    }

    @Test
    public void controll01() {
        Barrier barrier = Barrier.create("(BARRIERWAIT) 9 0x10eb39198 8 9");
        barrierListController.controll(barrier);
        Mockito.verify(barrierListController, Mockito.times(1)).barrierWaitfunction(barrier);
    }

    @Test
    public void controll02() {
        Barrier barrier = Barrier.create("(BARRIERUNLOCK) 0x10eb39198 9 9");
        barrierListController.controll(barrier);
        Mockito.verify(barrierListController, Mockito.times(1)).barrierUnlockFunction(barrier);
    }


    @Test
    public void barrierUnlockFunction() {
        Barrier barrierWait = Barrier.create("(BARRIERWAIT) 9 0x10eb39198 8 9");
        barrierListController.barrierWaitfunction(barrierWait);

        Barrier barrierUnlock = Barrier.create("(BARRIERUNLOCK) 0x10eb39198 9 9");
        barrierListController.barrierUnlockFunction(barrierUnlock);

        assertEquals(0, barrierModel.getElementByIndex(0).getCounter());
        assertEquals(null, barrierModel.getElementByIndex(0).getQueue());
    }

    @Test
    public void barrierWaitfunction01() {
        Barrier barrier = Barrier.create("(BARRIERWAIT) 8 0x10eb39198 7 9");
        barrierListController.barrierWaitfunction(barrier);
        assertEquals(1, barrierModel.listSize());
    }

    @Test
    public void barrierWaitfunction02() {
        Barrier barrier = Barrier.create("(BARRIERWAIT) 8 0x10eb39198 7 9");
        barrierListController.barrierWaitfunction(barrier);

        Barrier barrier1 = Barrier.create("(BARRIERWAIT) 8 0x10eb39198 8 9");
        barrierListController.barrierWaitfunction(barrier1);

        assertEquals(8, barrierModel.getElementByIndex(0).getCounter());
    }
}