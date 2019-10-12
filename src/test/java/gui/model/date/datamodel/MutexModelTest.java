package gui.model.date.datamodel;

import gui.model.date.Mutex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MutexModelTest {

    private List<Mutex> mutexList;
    private MutexModel mutexModel;

    @BeforeEach
    void setUp() {
        mutexList = new ArrayList<>();
        mutexModel = MutexModel.create(mutexList);
    }

    @Test
    void create01() {
        assertNull(MutexModel.create(null));
    }

    @Test
    void create02() {
        assertNotNull(mutexModel);
    }

    @Test
    void addElement() {
        mutexModel.addElement(Mockito.mock(Mutex.class));
        assertEquals(1, mutexList.size());
    }

    @Test
    void deleteElement() {
        mutexModel.addElement(Mockito.mock(Mutex.class));
        assertEquals(1, mutexList.size());

        mutexModel.deleteElement(0);
        assertEquals(0, mutexList.size());
    }

    @Test
    void updateElementQueue() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 1 0x1038c30b0");
        mutexModel.addElement(mutex);
        assertEquals(1, mutexList.size());
        assertEquals("", mutexList.get(0).getQueue());

        mutexModel.updateElementQueue(0, "2");
        assertEquals(1, mutexList.size());
        assertEquals("2", mutexList.get(0).getQueue());
    }

    @Test
    void listSize() {
        assertEquals(mutexList.size(), mutexModel.listSize());
    }

    @Test
    void getElementByIndex() {
        Mutex mutex = Mockito.mock(Mutex.class);
        mutexModel.addElement(mutex);
        assertEquals(mutex, mutexModel.getElementByIndex(0));
    }
}