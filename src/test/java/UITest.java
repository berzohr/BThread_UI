import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.*;

@Ignore ("Problema con test in cascata")
public class UITest extends ApplicationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UITest.class);
    private static final int ACTIONS_INTERVAL = 0;
    private int stepNo;

    @Override
    public void start(Stage stage) throws Exception {
        Main main = new Main();
        main.start(stage);
    }

    @Test
    public void testUI() {
        componentsTest();
        menuBarTest();
        aboutTest();
        fileOpenTest();
        tabTest();

        System.out.println("Fine test robotizzato");
    }

    private void componentsTest() {
        step("Components", () -> {
            verifyThat("#File", isVisible());
            verifyThat("#Thread", isVisible());
            verifyThat("#Help", isVisible());
            verifyThat("#openBtn", isVisible());
            verifyThat("#startBtn", isVisible());
            verifyThat("#stopBtn", isVisible());
            verifyThat("#restartBtn", isVisible());
            verifyThat("#monitoringBtn", isVisible());
            verifyThat("#ganttTab", isVisible());
            verifyThat("#stateTab", isVisible());
            verifyThat("#barrierTab", isVisible());
            verifyThat("#lockTab", isVisible());
            verifyThat("#mutexTab", isVisible());
            verifyThat("#semaphoreTab", isVisible());
            verifyThat("#conditionTab", isVisible());
        });
    }

    private void menuBarTest() {
        step("File menu", () -> {
            sleep(ACTIONS_INTERVAL);
            clickOn("#File");
            verifyThat("#OpenFile", isVisible());
            verifyThat("#Exit", isVisible());

            sleep(ACTIONS_INTERVAL);
            moveTo("#Thread");
            verifyThat("#Start", isVisible());
            verifyThat("#Pause", isVisible());
            verifyThat("#Stop", isVisible());
            verifyThat("#Restart", isVisible());
            verifyThat("#Monitoring", isVisible());

            sleep(ACTIONS_INTERVAL);
            moveTo("#Help");
            verifyThat("#About", isVisible());
        });
    }

    private void aboutTest(){
        step("About window", () -> {
            sleep(ACTIONS_INTERVAL);
            moveTo("#Help");
            verifyThat("#About", isVisible());
            clickOn("#About");
            sleep(ACTIONS_INTERVAL);
            moveTo("OK");
            clickOn("OK");
        });
    }

    private void fileOpenTest(){
        step("File Open", () -> {
            sleep(ACTIONS_INTERVAL);
            clickOn("#File");
            verifyThat("#OpenFile", isVisible());
            clickOn("#OpenFile");
            sleep(ACTIONS_INTERVAL);
            type(KeyCode.ESCAPE);
            clickOn("#openBtn");
            type(KeyCode.ESCAPE);
        });
    }

    private void tabTest() {
        step("Tab tables", () -> {
            sleep(ACTIONS_INTERVAL);
            moveTo("#ganttTab");
            clickOn("#stateTab");
            clickOn("#barrierTab");
            clickOn("#lockTab");
            clickOn("#mutexTab");
            clickOn("#semaphoreTab");
            clickOn("#conditionTab");
        });
    }

    private void step(final String step, final Runnable runnable) {
        ++stepNo;
        LOGGER.info("STEP {}: {}", stepNo, step);
        runnable.run();
        LOGGER.info("STEP {}: End", stepNo);
    }
}

