package gui.controller;

import gui.model.AboutWindow;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class AboutWindowControllerTest {

    private AboutWindowController aboutWindowController;

    @Mock
    private Stage stage;
    @Mock
    private AboutWindow aboutWindow;

    @BeforeEach
    public void setUp() {
        stage = Mockito.mock(Stage.class);
        aboutWindow = Mockito.mock(AboutWindow.class);
        aboutWindowController = AboutWindowController.create(stage, aboutWindow);
    }

    @Test
    public void create01() {
        assertNull(AboutWindowController.create(null, aboutWindow));
    }

    @Test
    public void create02() {
        assertNull(AboutWindowController.create(stage, null));
    }

    @Test
    public void create03() {
        assertNotNull(aboutWindowController);
    }

    @Test
    public void aboutWindow() {
        aboutWindowController.aboutWindow();
        Mockito.verify(aboutWindow, Mockito.times(1)).aboutWindow();
    }
}