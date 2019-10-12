package gui.model.date.datamodel;

import gui.model.date.Semaphore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SemaphoreModelTest {

    private List<Semaphore> semaphoreList;
    private SemaphoreModel semaphoreModel;

    @BeforeEach
    void setUp() {
        semaphoreList = new ArrayList<>();
        semaphoreModel = SemaphoreModel.create(semaphoreList);
    }

    @Test
    void create01() {
        assertNull(SemaphoreModel.create(null));
    }

    @Test
    void create02() {
        assertNotNull(semaphoreModel);
    }

    @Test
    void addElement() {
        Semaphore semaphore = Mockito.mock(Semaphore.class);
        semaphoreModel.addElement(semaphore);
        assertEquals(1, semaphoreList.size());
    }

    @Test
    void deleteElement() {
        Semaphore semaphore = Mockito.mock(Semaphore.class);
        semaphoreModel.addElement(semaphore);
        assertEquals(1, semaphoreList.size());

        semaphoreModel.deleteElement(0);
        assertEquals(0, semaphoreList.size());
    }

    @Test
    void updateElementQueue() {
        Semaphore semaphore = Semaphore.create("(SEMACQUIRE) 5 0x1038c3100 0");
        semaphoreModel.addElement(semaphore);
        assertEquals(1, semaphoreList.size());
        assertEquals("", semaphoreList.get(0).getQueue());

        semaphoreModel.updateElementQueue(0, "1");
        assertEquals(1, semaphoreList.size());
        assertEquals("1", semaphoreList.get(0).getQueue());
    }

    @Test
    void updateElementCounter() {
        Semaphore semaphore = Semaphore.create("(SEMACQUIRE) 5 0x1038c3100 0");
        semaphoreModel.addElement(semaphore);
        assertEquals(1, semaphoreList.size());
        assertEquals(0, semaphoreList.get(0).getCounter());

        semaphoreModel.updateElementCounter(0, 1);
        assertEquals(1, semaphoreList.size());
        assertEquals(1, semaphoreList.get(0).getCounter());
    }

    @Test
    void listSize() {
        assertEquals(semaphoreList.size(), semaphoreModel.listSize());
    }

    @Test
    void getElementByIndex() {
        Semaphore semaphore = Mockito.mock(Semaphore.class);
        semaphoreModel.addElement(semaphore);
        assertEquals(semaphore, semaphoreModel.getElementByIndex(0));
    }
}