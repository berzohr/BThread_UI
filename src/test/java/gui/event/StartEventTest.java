package gui.event;

import gui.style.Style;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartEventTest {

    private String fileName = "fileName";
    private final StartEvent startEvent = new StartEvent(fileName);

    @Test
    public void getString() {
        assertEquals(Style.getHour() + "[INFO]  Start process: " + fileName, startEvent.getString());
    }
}