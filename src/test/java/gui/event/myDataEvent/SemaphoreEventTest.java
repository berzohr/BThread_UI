package gui.event.myDataEvent;

import org.junit.Test;

import static org.junit.Assert.*;

public class SemaphoreEventTest {

    private SemaphoreEvent semaphoreEvent;

    @Test
    public void create01() {
        semaphoreEvent = (SemaphoreEvent) SemaphoreEvent.create(null);
        assertNull(semaphoreEvent);
    }

    @Test
    public void create02() {
        semaphoreEvent = (SemaphoreEvent) SemaphoreEvent.create("(SEMAPHORE) 1 0x623747 0");
        assertNotNull(semaphoreEvent);
    }

    @Test
    public void getSemaphore() {
        semaphoreEvent = (SemaphoreEvent) SemaphoreEvent.create("(SEMAPHORE) 1 0x623747 0");
        assertNotNull(semaphoreEvent.data);
        assertEquals(semaphoreEvent.data, semaphoreEvent.getData());
    }
}