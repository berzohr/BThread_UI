package gui.event;


import gui.style.Style;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewLineReadEventTest {

    private String line;
    private final NewLineReadEvent newLineReadEvent = new NewLineReadEvent(line);

    @Test
    public void getLine() {
        assertEquals(Style.getHour() + "[MONITORING] "+ line, newLineReadEvent.getLine());
    }
}