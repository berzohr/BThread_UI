package gui.view.menubar;

import gui.controller.AboutWindowController;
import gui.controller.ChooseFileController;
import gui.controller.ExitController;
import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import gui.view.JavaFXInitTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MenuBarViewTest {

    private ProcessController controller;
    private AboutWindowController aboutWindowController;
    private ExitController exitController;
    private ChooseFileController chooseFileController;
    private ExecutableFile executableFile;
    private MenuBarView menuBarView;

    @Before
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        controller = Mockito.mock(ProcessController.class);
        aboutWindowController = Mockito.mock(AboutWindowController.class);
        exitController = Mockito.mock(ExitController.class);
        chooseFileController = Mockito.mock(ChooseFileController.class);
        executableFile = Mockito.mock(ExecutableFile.class);
        menuBarView = MenuBarView.create(controller, aboutWindowController, exitController, chooseFileController, executableFile);
    }

    @Test
    public void create01() {
        assertNull(MenuBarView.create(null, aboutWindowController, exitController, chooseFileController, executableFile));
        assertNull(MenuBarView.create(controller, null, exitController, chooseFileController, executableFile));
        assertNull(MenuBarView.create(controller, aboutWindowController, null, chooseFileController, executableFile));
        assertNull(MenuBarView.create(controller, aboutWindowController, exitController, null, executableFile));
        assertNull(MenuBarView.create(controller, aboutWindowController, exitController, chooseFileController, null));
    }

    @Test
    public void create02() {
        assertNotNull(menuBarView);
    }


    @Test
    public void getMenu1() {
        assertEquals(menuBarView.menuBar, menuBarView.getMenu());
    }

    @Test
    public void getStartProcessItemMenu() {
        assertEquals(menuBarView.startItemMenu, menuBarView.getStartProcessItemMenu());
    }

    @Test
    public void getStopProcessItemMenu() {
        assertEquals(menuBarView.stopItemMenu, menuBarView.getStopProcessItemMenu());
    }

    @Test
    public void getStartMonitoringItemMenu() {
        assertEquals(menuBarView.startMonitoringItemMenu, menuBarView.getStartMonitoringItemMenu());
    }

    @Test
    public void getRestartItemMenu() {
        assertEquals(menuBarView.restartItemMenu, menuBarView.getRestartItemMenu());
    }

    @Test
    public void getPauseItemMenu() {
        assertEquals(menuBarView.pauseItemMenu, menuBarView.getPauseItemMenu());
    }

    @Test
    public void getWindowItemMenu1() {
        assertEquals(menuBarView.aboutItemMenu, menuBarView.getWindowItemMenu());
    }

    @Test
    public void getChooseFileItemMenu() {
        assertEquals(menuBarView.chooseFileItemMenu, menuBarView.getChooseFileItemMenu());
    }
}