package gui.model.date;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SemaphoreTest {

    private Semaphore semaphore;

    @Before
    public void setUp() {
        semaphore = Semaphore.create("(SEMACQUIRE) 5 0x8756845 0");
    }

    @Test
    public void create01() {
        Semaphore semaphore = Semaphore.create(null);
        assertNull(semaphore);
    }

    @Test
    public void create02() {
        assertNotNull(semaphore);
    }

    @Test
    public void create03() {
        Semaphore semaphore = Semaphore.create("(SEMBLOCK) 5");
        assertNotNull(semaphore);
    }

    @Test
    public void getAddress() {
        assertEquals(semaphore.address.get(), semaphore.getAddress());
    }

    @Test
    public void getThreadId() {
        assertEquals(semaphore.threadId.get(), semaphore.getThreadId());
    }

    @Test
    public void getQueue() {
        assertEquals(semaphore.queue.get(), semaphore.getQueue());
    }

    @Test
    public void setQueue() {
        semaphore.setQueue("1");
        assertEquals("1", semaphore.getQueue());
    }

    @Test
    public void getCounter() {
        assertEquals(semaphore.counter.get(), semaphore.getCounter());
    }

    @Test
    public void setCounter() {
        semaphore.setCounter(1);
        assertEquals(1, semaphore.getCounter());
    }

    @Test
    public void getStatus() {
        assertEquals(semaphore.status.get(), semaphore.getStatus());
    }
}