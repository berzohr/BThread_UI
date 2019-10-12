package gui.event.myDataEvent;

import org.junit.Test;

import static org.junit.Assert.*;

public class MutexEventTest {

    private MutexEvent mutexEvent;

    @Test
    public void create01() {
        mutexEvent = (MutexEvent) MutexEvent.create(null);
        assertNull(mutexEvent);
    }

    @Test
    public void create02() {
        mutexEvent = (MutexEvent) MutexEvent.create("(MUTEX) 1 0x623747");
        assertNotNull(mutexEvent);
    }

    @Test
    public void getMutex() {
        mutexEvent = (MutexEvent) MutexEvent.create("(MUTEX) 1 0x623747");
        assertNotNull(mutexEvent.data);
        assertEquals(mutexEvent.data, mutexEvent.getData());
    }
}