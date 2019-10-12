package gui.event;

import org.junit.Test;

import static org.junit.Assert.*;

public class PauseEventTest {

    private String fileName = "fileName";
    private final PauseEvent pauseEvent = new PauseEvent(fileName);

    @Test
    public void getString() {
        assertEquals("Pause process: " + fileName, pauseEvent.getString());
    }
}