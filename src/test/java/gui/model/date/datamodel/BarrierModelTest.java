package gui.model.date.datamodel;

import gui.model.date.Barrier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BarrierModelTest {

    private List<Barrier> barrierList;
    private BarrierModel barrierModel;

    @BeforeEach
    public void setUp() {
        barrierList = new ArrayList<>();
        barrierModel = BarrierModel.create(barrierList);
    }

    @Test
    public void create01() {
        assertNull(BarrierModel.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(barrierModel);
    }

    @Test
    public void addElement() {
        barrierModel.addElement(Mockito.mock(Barrier.class));
        assertEquals(1, barrierList.size());
    }

    @Test
    public void deleteElement() {
        barrierModel.addElement(Mockito.mock(Barrier.class));
        assertEquals(1, barrierList.size());

        barrierModel.deleteElement(0);
        assertEquals(0, barrierList.size());
    }

    @Test
    public void updateElementQueue() {
        Barrier barrier = Barrier.create("(BARRIERWAIT) 4 0x10d5bf198 3 9");
        barrierModel.addElement(barrier);
        assertEquals(1, barrierList.size());
        assertEquals("", barrierList.get(0).getQueue());

        barrierModel.updateElementQueue(0, "2");
        assertEquals(1, barrierList.size());
        assertEquals("2", barrierList.get(0).getQueue());
    }

    @Test
    public void updateElementCounter() {
        Barrier barrier = Barrier.create("(BARRIERWAIT) 4 0x10d5bf198 3 9");
        barrierModel.addElement(barrier);
        assertEquals(1, barrierList.size());
        assertEquals(3, barrierList.get(0).getCounter());

        barrierModel.updateElementCounter(0, 4);
        assertEquals(1, barrierList.size());
        assertEquals(4, barrierList.get(0).getCounter());
    }

    @Test
    public void listSize() {
        assertEquals(barrierList.size(), barrierModel.listSize());
    }

    @Test
    public void getElementByIndex() {
        Barrier barrier = Mockito.mock(Barrier.class);
        barrierModel.addElement(barrier);
        assertEquals(barrier, barrierModel.getElementByIndex(0));
    }
}