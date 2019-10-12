package gui.model.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BarrierTest {

    private Barrier barrier;
    private String line;

    @BeforeEach
    public void setUp() {
        line = "(BARRIERWAIT) 5 0x102663198 4 9";
        barrier = Barrier.create(line);
    }

    @Test
    public void create01() {
        assertNull(Barrier.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(barrier);
    }

    @Test
    void create03() {
        assertNotNull(Barrier.create("(BARRIERUNLOCK) 0x106988198 9 9"));
    }

    @Test
    public void create04() {
        assertEquals(barrier.address.get(), barrier.getAddress());
        assertEquals(barrier.status.get(), barrier.getStatus());
        assertEquals(barrier.threadId.get(), barrier.getThreadId());
        assertEquals(barrier.counter.get(), barrier.getCounter());
        assertEquals(barrier.size.get(), barrier.getSize());
        assertEquals(barrier.queue.get(), barrier.getQueue());
    }

    @Test
    public void getSize() {
        assertEquals(barrier.size.get(), barrier.getSize());
    }

    @Test
    public void setSize() {
        barrier.setSize(3);
        assertEquals(3, barrier.getSize());
    }

    @Test
    public void getCounter() {
        assertEquals(barrier.counter.get(), barrier.getCounter());
    }

    @Test
    public void setCounter() {
        barrier.setCounter(3);
        assertEquals(3, barrier.getCounter());
    }

    @Test
    public void getQueue() {
        assertEquals(barrier.queue.get(), barrier.getQueue());
    }

    @Test
    public void setQueue() {
        barrier.setQueue("1 , 2");
        assertEquals("1 , 2", barrier.getQueue());
    }
}