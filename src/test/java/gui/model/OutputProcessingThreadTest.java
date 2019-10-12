package gui.model;

import gui.model.date.Monitoring;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class OutputProcessingThreadTest {

    private Parser parser;
    private Monitoring monitoring;
    private OutputProcessingThread outputProcessingThread;

    @BeforeEach
    public void setUp() {
        parser = Mockito.mock(Parser.class);
        monitoring = Mockito.mock(Monitoring.class);
        outputProcessingThread = OutputProcessingThread.create(parser, monitoring);
    }

    @Test
    public void create01() {
        assertNull(OutputProcessingThread.create(null, monitoring));
        assertNull(OutputProcessingThread.create(parser, null));
    }

    @Test
    public void create02() {
        assertNotNull(outputProcessingThread);
    }

    @Test
    public void setProcess() {
        Process process = Mockito.mock(Process.class);
        outputProcessingThread.setProcess(process);
        assertEquals(outputProcessingThread.process, process);
    }

    @Test
    public void setIsMonitoring() {
        outputProcessingThread.setIsMonitoring(true);
        assertTrue(outputProcessingThread.isMonitoring.get());
    }
}