package gui.view.console;

import gui.view.JavaFXInitTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ConsoleViewTest {


    @BeforeClass
    public static void setup() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
    }

    @Test
    public void create() {
        ConsoleView consoleView = (ConsoleView) ConsoleView.create();
        assertNotNull(consoleView);
    }

    @Test
    public void getConsole() {
        ConsoleView consoleView = (ConsoleView) ConsoleView.create();
        assertEquals(consoleView.console, consoleView.getConsole());
    }

    @Test
    public void update() {

    }
}