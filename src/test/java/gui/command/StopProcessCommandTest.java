package gui.command;

import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import gui.singleton.MainProcess;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class StopProcessCommandTest {

    private ProcessController receiver;
    private ExecutableFile executableFile;
    private StopProcessCommand stopProcessCommand;


    @Before
    public void BeforeEachTestMethod() {

        receiver = Mockito.mock(ProcessController.class);
        executableFile = new ExecutableFile();
        executableFile.setExecFile("./executableFiles/matrix_cube");
        stopProcessCommand = Mockito.spy(StopProcessCommand.create(receiver, executableFile));
        Mockito.doReturn(Mockito.mock(Process.class)).when(stopProcessCommand).stopProcess();
    }

    @Test
    public void create01() {
        assertNull(StopProcessCommand.create(null, executableFile));
    }

    @Test
    public void create02() {
        assertNull(StopProcessCommand.create(receiver, null));
    }

    @Test
    public void create03() {
        assertNotNull(stopProcessCommand);
    }

    @Test
    public void execute() {
        stopProcessCommand.execute();
        Mockito.verify(receiver, Mockito.times(1)).stopProcess(stopProcessCommand.stopProcess(), executableFile.getExecFile());
    }

    @Test
    public void stopProcess02() {
        assertNotNull(stopProcessCommand.stopProcess());
    }
}