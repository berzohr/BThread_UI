package gui.event.myDataEvent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionEventTest {

    @Test
    public void create01() {
        assertNull(ConditionEvent.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(ConditionEvent.create("(CONDSIGNAL) 3 0x10a9060b8"));
    }

    @Test
    public void create03() {
        ConditionEvent conditionEvent = (ConditionEvent) ConditionEvent.create("(CONDSIGNAL) 3 0x10a9060b8");
        assertEquals(conditionEvent.data, conditionEvent.getData());
    }
}