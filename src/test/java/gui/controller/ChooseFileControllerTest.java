package gui.controller;

import gui.model.ChooseFile;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;

public class ChooseFileControllerTest {

    private ChooseFileController chooseFileController;

    @Mock
    private Stage stage;
    @Mock
    private ChooseFile chooseFile;

    @BeforeEach
    public void setUp() {
        stage = Mockito.mock(Stage.class);
        chooseFile = Mockito.mock(ChooseFile.class);
        chooseFileController = ChooseFileController.create(stage, chooseFile);
    }

    @Test
    public void create01() {
        assertNull(ChooseFileController.create(null, chooseFile));
    }

    @Test
    public void create02() {
        assertNull(ChooseFileController.create(stage, null));
    }

    @Test
    public void create03() {
        assertNotNull(chooseFileController);
    }

    @Test
    public void isValid() {
        File file = new File("/");
        assertEquals(true, chooseFileController.isValid(file));
    }

    @Test
    public void chooseFileProcess() {
        chooseFileController.chooseFileProcess();
        Mockito.verify(chooseFile, Mockito.times(1)).chooseFileProcess();
    }

    @Test
    public void getStage() {
        assertEquals(chooseFileController.stage, chooseFileController.getStage());
    }

    @Test
    public void getFileChooser() {
        assertEquals(chooseFileController.fileChooser, chooseFileController.getFileChooser());
    }
}