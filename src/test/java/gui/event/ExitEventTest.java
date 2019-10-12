package gui.event;


import org.junit.Test;

import static org.junit.Assert.*;

public class ExitEventTest {

    private final ExitEvent exitEvent = new ExitEvent();

    @Test
    public void getString() {
        assertEquals("Chiusura in corso......\n", exitEvent.getString());
    }
}