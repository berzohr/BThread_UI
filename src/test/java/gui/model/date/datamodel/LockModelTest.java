package gui.model.date.datamodel;

import gui.model.date.Lock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LockModelTest {

    private List<Lock> lockList;
    private LockModel lockModel;

    @BeforeEach
    public void setUp() {
        lockList = new ArrayList<>();
        lockModel = LockModel.create(lockList);
    }

    @Test
    public void create01() {
        assertNull(LockModel.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(lockModel);
    }

    @Test
    public void addElement() {
        lockModel.addElement(Mockito.mock(Lock.class));
        assertEquals(1, lockList.size());
    }

    @Test
    public void deleteElement() {
        lockModel.addElement(Mockito.mock(Lock.class));
        assertEquals(1, lockList.size());

        lockModel.deleteElement(0);
        assertEquals(0, lockList.size());
    }

    @Test
    public void updateElementStatus() {

    }

    @Test
    public void listSize() {
        assertEquals(lockList.size(), lockModel.listSize());
    }

    @Test
    public void getElementByIndex() {
        Lock lock = Mockito.mock(Lock.class);
        lockModel.addElement(lock);
        assertEquals(lock, lockModel.getElementByIndex(0));
    }
}