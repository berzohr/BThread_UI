package gui.command;

import gui.controller.ChooseFileController;
import gui.model.ExecutableFile;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ChooseFileCommandTest {

    private ChooseFileController chooseFileController;
    private ExecutableFile executableFile;
    private ChooseFileCommand chooseFileCommand;

    @BeforeEach
    public void setUp() {
        chooseFileController = Mockito.mock(ChooseFileController.class);
        executableFile = Mockito.mock(ExecutableFile.class);
        chooseFileCommand = Mockito.spy(ChooseFileCommand.create(chooseFileController, executableFile));

    }

    @Test
    public void create01() {
        assertNull(ChooseFileCommand.create(null, executableFile));
    }

    @Test
    public void create02() {
        assertNull(ChooseFileCommand.create(chooseFileController, null));
    }

    @Test
    public void create03() {
        assertNotNull(chooseFileCommand);
    }

}