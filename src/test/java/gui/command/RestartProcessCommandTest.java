package gui.command;


import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class RestartProcessCommandTest {


    private ProcessController receiver;
    private ExecutableFile executableFile;
    private RestartProcessCommand restartProcessCommand;

    @Before
    public void BeforeEachTestMethod() {
        receiver = Mockito.mock(ProcessController.class);
        executableFile = new ExecutableFile();
        executableFile.setExecFile("./executableFiles/philosophers");
        restartProcessCommand = Mockito.spy(RestartProcessCommand.create(receiver, executableFile));
        Mockito.doReturn(null).when(restartProcessCommand).getProcess();
        Mockito.doReturn(null).when(restartProcessCommand).initProcess(executableFile.getExecFile());
    }

    @Test
    public void execute01() {
        assertNull(RestartProcessCommand.create(null, executableFile));
    }

    @Test
    public void execute02() {
        assertNull(RestartProcessCommand.create(receiver, null));
    }

    @Test
    public void execute03() {
        assertNotNull(restartProcessCommand);
    }

}