package gui.command;


import gui.controller.ProcessController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;


public class StartMonitoringCommandTest {

    private ProcessController receiver;
    private StartMonitoringCommand startMonitoringCommand;

    @Before
    public void BeforeEachTestMethod() {
        receiver = Mockito.mock(ProcessController.class);
        startMonitoringCommand = StartMonitoringCommand.create(receiver);
    }

    @Test
    public void create01() {
        assertNull(StartMonitoringCommand.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(startMonitoringCommand);
    }

    @Test
    public void execute() {
        startMonitoringCommand.execute();
        Mockito.verify(receiver, Mockito.times(1)).startMonitoring(any(Process.class));
    }
}