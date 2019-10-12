package gui.event;

import gui.style.Style;
import org.junit.Test;

import static org.junit.Assert.*;

public class StopEventTest {

    private String fileName = "fileName";
    private final StopEvent stopEvent = new StopEvent(fileName);

    @Test
    public void getString() {
        assertEquals(Style.getHour() + "[INFO]  Stop process: " + fileName, stopEvent.getString());
    }
}