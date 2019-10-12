package gui.view.menubar;

import gui.view.JavaFXInitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuFactoryTest {

    private MenuFactory menuFactory;

    @BeforeEach
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        menuFactory = MenuFactory.instance();
    }

    @Test
    public void instance() {
        assertNotNull(menuFactory);
    }

    @Test
    public void createMenu() {
        assertNotNull(menuFactory.createMenu("Thread"));
    }
}