package gui.model.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockTest {

    private Lock lock;
    private String line;

    @BeforeEach
    public void setUp() {
        line = "(SCHEDULING) 5";
        lock = Lock.create(line);
    }

    @Test
    public void create01() {
        assertNull(Lock.create(null));
    }


    @Test
    public void create02() {
        assertNotNull(lock);
        assertEquals("SCHEDULING", lock.status.get());
        assertEquals(5, lock.threadId.get());
    }
}