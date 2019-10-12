package gui.event.myDataEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockEventTest {

    private String line;
    private LockEvent lockEvent;

    @BeforeEach
    public void setUp() {
        line = "(SCHEDULING) 2";
        lockEvent = (LockEvent) LockEvent.create(line);
    }

    @Test
    public void create01() {
        assertNull(LockEvent.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(lockEvent);
    }

    @Test
    public void getData() {
        assertEquals(lockEvent.data, lockEvent.getData());
    }
}