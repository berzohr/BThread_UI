package gui.model.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonitoringTest {

    private Monitoring monitoring;

    @BeforeEach
    public void setUp() {
        monitoring = new Monitoring();
    }

    @Test
    public void create01() {
        assertNotNull(monitoring);
    }

    @Test
    public void validateLine01() {
        assertFalse(monitoring.validateLine(null));
    }

    @Test
    public void validateLine02() {
        assertFalse(monitoring.validateLine("CREATE 1"));
    }

    @Test
    public void validateLine03() {
        assertTrue(monitoring.validateLine("(CREATE) 1"));
    }
}