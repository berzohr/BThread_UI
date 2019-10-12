package gui.event;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class MonitoringStartedEventTest {

    @Test
    public void create() {
        MonitoringStartedEvent monitoringStartedEvent = new MonitoringStartedEvent();
        assertNotNull(monitoringStartedEvent);
    }

}