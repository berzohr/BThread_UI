package gui.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;

public class MainProcessTest {

    private MainProcess mainProcess;

    @BeforeEach
    public void setUp() {
        mainProcess = MainProcess.istance;
    }

    @Test
    public void getCurrentProcess() {
        assertEquals(mainProcess.currentProcess, mainProcess.getCurrentProcess());
    }

    @Test
    public void getMainProcess() {
        assertEquals(mainProcess, MainProcess.getMainProcess());
    }

    @Test
    public void setCurrentProcess() {
        Process process = Mockito.mock(Process.class);
        mainProcess.setCurrentProcess(process);
        assertNotNull(mainProcess.currentProcess);
    }
}