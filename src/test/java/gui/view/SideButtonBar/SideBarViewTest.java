package gui.view.SideButtonBar;

import gui.controller.ChooseFileController;
import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import gui.view.JavaFXInitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class SideBarViewTest {

    private ExecutableFile executableFile;
    private SideBarView sideBarView;
    private ProcessController processController;
    private ChooseFileController chooseFileController;

    @BeforeEach
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        executableFile = Mockito.mock(ExecutableFile.class);
        processController = Mockito.mock(ProcessController.class);
        chooseFileController = Mockito.mock(ChooseFileController.class);
        sideBarView = SideBarView.create(processController, chooseFileController, executableFile);
    }

    @Test
    public void create01() {
        assertNull(SideBarView.create(null, chooseFileController, executableFile));
    }

    @Test
    public void create02() {
        assertNull(SideBarView.create(processController, null, executableFile));
    }

    @Test
    public void create03() {
        assertNull(SideBarView.create(processController, chooseFileController, null));
    }

    @Test
    public void create04() {
        assertNotNull(sideBarView);
    }

    @Test
    public void getSideLeftBar() {
        assertEquals(sideBarView.sideLeftBar, sideBarView.getSideLeftBar());
    }

    @Test
    public void getOpenBtn() {
        assertEquals(sideBarView.openBtn, sideBarView.getOpenBtn());
    }

    @Test
    public void getStartBtn() {
        assertEquals(sideBarView.startBtn, sideBarView.getStartBtn());
    }

    @Test
    public void getStopBtn() {
        assertEquals(sideBarView.stopBtn, sideBarView.getStopBtn());
    }

    @Test
    public void getPauseBtn() {
        assertEquals(sideBarView.pauseBtn, sideBarView.getPauseBtn());
    }

    @Test
    public void getRestartBtn() {
        assertEquals(sideBarView.restartBtn, sideBarView.getRestartBtn());
    }

    @Test
    public void getMonitoringBtn() {
        assertEquals(sideBarView.monitoringBtn, sideBarView.getMonitoringBtn());
    }
}