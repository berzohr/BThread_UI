package gui.model.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatusTest {

    private Status status;
    private String line;

    @BeforeEach
    public void setUp() {
        line = "(CREATE) 1";
        status = Status.create(line);
    }

    @Test
    public void create01() {
        assertNull(Status.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(status);
    }
}