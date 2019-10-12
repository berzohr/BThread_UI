package gui.command;

import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.hamcrest.Matchers.any;
import static org.junit.Assert.*;

public class StartProcessCommandTest {

    private ExecutableFile executableFile;
    private ProcessController receiver;
    private StartProcessCommand startProcessCommand;

    @Before
    public void BeforeEachTestMethod() {
        receiver = Mockito.mock(ProcessController.class);
        executableFile = new ExecutableFile();
        executableFile.setExecFile("./executableFiles/matrix_cube");
        startProcessCommand = Mockito.spy(StartProcessCommand.create(receiver, executableFile));
        Mockito.doReturn(null).when(startProcessCommand).initProcess(executableFile.getExecFile());
    }

    @Test
    public void create01() {
        assertNull(StartProcessCommand.create(null, executableFile));
    }

    @Test
    public void create02() {
        assertNull(StartProcessCommand.create(receiver, null));
    }

    @Test
    public void create03() {
        assertNotNull(startProcessCommand);
    }

    @Test
    public void execute() throws IOException {
        startProcessCommand.execute();
        Mockito.verify(receiver, Mockito.times(1)).startProcess(startProcessCommand.initProcess(executableFile.getExecFile()), executableFile.getExecFile());
    }
}