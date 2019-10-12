package gui.event.myDataEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatusEventTest {

    private StatusEvent statusEvent;
    private String line;

    @BeforeEach
    public void setUp() {
        line = "(CREATE) 1";
        statusEvent = StatusEvent.create(line);
    }

    @Test
    public void create01() {
        assertNull(StatusEvent.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(statusEvent);
    }
}