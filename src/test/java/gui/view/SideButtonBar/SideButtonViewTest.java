package gui.view.SideButtonBar;

import gui.command.StartProcessCommand;
import gui.view.JavaFXInitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class SideButtonViewTest {

    private SideButtonView sideButtonView;
    private StartProcessCommand startProcessCommand;

    @BeforeEach
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        startProcessCommand = Mockito.mock(StartProcessCommand.class);
        sideButtonView = SideButtonView.create("openBtn", startProcessCommand);
    }

    @Test
    public void create01() {
        assertNull(SideButtonView.create(null, startProcessCommand));
    }

    @Test
    public void create02() {
        assertNull(SideButtonView.create("openBtn", null));
    }


    @Test
    public void create04() {
        assertNotNull(sideButtonView);
    }

    @Test
    public void getSideButton() {
        assertEquals(sideButtonView.button, sideButtonView.getSideButton());
    }

}