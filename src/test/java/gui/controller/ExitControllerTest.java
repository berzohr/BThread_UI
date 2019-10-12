package gui.controller;

import gui.model.Exit;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ExitControllerTest {

    private ExitController exitController;

    @Mock
    private Stage stage;
    @Mock
    private Exit exit;

    @BeforeEach
    public void setUp() {
        stage = Mockito.mock(Stage.class);
        exit = Mockito.mock(Exit.class);
        exitController = ExitController.create(exit);
        exitController.setStage(stage);
    }

    @Test
    public void create01() {
        assertNull(ExitController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(exitController);
    }

    @Test
    public void exitProcess() {
        exitController.exitProcess();
        Mockito.verify(exit, Mockito.times(1)).exitProcess();
    }

    @Test
    public void getStage() {
        assertEquals(exitController.stage, exitController.getStage());
    }

    @Test
    public void setStage() {
        Stage stage1 = Mockito.mock(Stage.class);
        exitController.setStage(stage1);
        assertEquals(stage1, exitController.stage);
    }
}