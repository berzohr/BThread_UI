package gui.command;

import gui.controller.ExitController;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ExitCommandTest {

    private ExitCommand exitCommand;
    private ExitController exitController;

    @BeforeEach
    public void setUp() {
        exitController = Mockito.mock(ExitController.class);
        exitController.setStage(Mockito.mock(Stage.class));
        exitCommand = Mockito.spy(ExitCommand.create(exitController));
        Mockito.doNothing().when(exitController).closeStage();
    }

    @Test
    public void create01() {
        assertNull(ExitCommand.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(exitCommand);
    }

    @Test
    public void execute() {
        exitCommand.execute();
        Mockito.verify(exitController, Mockito.times(1)).exitProcess();
    }
}