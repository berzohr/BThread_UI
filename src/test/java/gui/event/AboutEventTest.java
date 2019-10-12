package gui.event;

import gui.style.Style;
import org.junit.Assert;
import org.junit.Test;

public class AboutEventTest {
    private final AboutEvent aboutEvent = new AboutEvent();

    @Test
    public void getString() {
        Assert.assertEquals( Style.getHour() + "[INFO] Open About Window\n", aboutEvent.getString());
    }

}