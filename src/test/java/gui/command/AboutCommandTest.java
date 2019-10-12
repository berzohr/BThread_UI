package gui.command;

import gui.controller.AboutWindowController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class AboutCommandTest {

    private AboutWindowController aboutWindowController;
    private AboutCommand aboutCommand;

    @BeforeEach
    public void setUp() {
        aboutWindowController = Mockito.mock(AboutWindowController.class);
        aboutCommand = AboutCommand.create(aboutWindowController);
    }

    @Test
    public void create01() {
        assertNull(AboutCommand.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(aboutCommand);
    }

    @Test
    public void execute() {
        aboutCommand.execute();
        Mockito.verify(aboutWindowController, Mockito.times(1)).aboutWindow();
    }
}