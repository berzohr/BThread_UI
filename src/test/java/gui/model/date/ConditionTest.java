package gui.model.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionTest {

    private Condition condition;
    private String line;

    @BeforeEach
    public void setUp() {
        line = "(CONDSIGNAL) 1 0x10b0040b0";
        condition = Condition.create(line);
    }

    @Test
    public void create01() {
        assertNull(Condition.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(condition);
    }

    @Test
    public void create03() {
        assertEquals(condition.address.get(), condition.getAddress());
        assertEquals(condition.status.get(), condition.getStatus());
        assertEquals(condition.threadId.get(), condition.getThreadId());
        assertEquals(condition.queue.get(), condition.getQueue());
    }

    @Test
    public void getQueue() {
        assertEquals(condition.queue.get(), condition.getQueue());
    }

    @Test
    public void setQueue() {
        condition.setQueue("1 , 2");
        assertEquals("1 , 2", condition.getQueue());
    }
}