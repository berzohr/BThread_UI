package gui.event.myDataEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GanttEventTest {

    private GanttEvent ganttEvent;

    @BeforeEach
    public void setUp() {
        ganttEvent = GanttEvent.create("(CREATE) 1");
    }

    @Test
    public void create01() {
        assertNull(GanttEvent.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(ganttEvent);
    }
}