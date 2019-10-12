package gui.model.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GanttTest {

    private Gantt gantt;

    @BeforeEach
    public void setUp() {
        gantt = Gantt.create("(CREATE) 1");
    }

    @Test
    public void create01() {
        assertNull(Gantt.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(gantt);
    }
}