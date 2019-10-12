package gui.command;

import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;

public class PauseProcessCommandTest {


    private ProcessController receiver;
    private ExecutableFile executableFile;
    private PauseProcessCommand pauseProcessCommand;


    @Before
    public void BeforeEachTestMethod() {
        receiver = Mockito.mock(ProcessController.class);
        executableFile = new ExecutableFile();
        executableFile.setExecFile("./executableFiles/matrix_cube");
        pauseProcessCommand = Mockito.spy(PauseProcessCommand.create(receiver, executableFile));
    }

    @Test
    public void create01() {
        assertNull(PauseProcessCommand.create(null, executableFile));
    }

    @Test
    public void create02() {
        assertNull(PauseProcessCommand.create(receiver, null));
    }

    @Test
    public void create03() {
        assertNotNull(pauseProcessCommand);
    }


    @Test
    public void execute() {
        pauseProcessCommand.execute();
        Mockito.verify(receiver, Mockito.times(1)).pauseProcess(any(Process.class), any(String.class));
    }
}