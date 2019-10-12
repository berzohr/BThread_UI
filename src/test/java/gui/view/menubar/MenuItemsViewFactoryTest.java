package gui.view.menubar;

import gui.command.StartProcessCommand;
import gui.controller.ProcessController;
import gui.view.JavaFXInitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MenuItemsViewFactoryTest {

    private MenuItemsViewFactory menuItemsViewFactory;

    @BeforeEach
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        menuItemsViewFactory = MenuItemsViewFactory.instance();
    }

    @Test
    public void instance() {
        assertNotNull(menuItemsViewFactory);
    }

    @Test
    public void createMenuItem() {
        //assertNotNull(menuItemsViewFactory.createMenuItem("Start", Mockito.mock(StartProcessCommand.class), Mockito.mock(ProcessController.class)));
    }
}