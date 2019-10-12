package gui.event.myDataEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BarrierEventTest {

    private BarrierEvent barrierEvent;
    private String line;

    @BeforeEach
    void setUp() {
        line = "(BARRIERWAIT) 5 0x102663198 4 9";
        barrierEvent = (BarrierEvent) BarrierEvent.create(line);
    }

    @Test
    public void create01() {
        assertNull(BarrierEvent.create(null));
    }

    @Test
    void create02() {
        assertNotNull(ConditionEvent.create(line));
    }

    @Test
    void create03() {
        assertEquals(barrierEvent.data, barrierEvent.getData());
    }
}