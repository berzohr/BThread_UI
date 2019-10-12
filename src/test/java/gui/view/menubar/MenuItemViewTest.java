package gui.view.menubar;

import gui.command.StartProcessCommand;
import gui.controller.ProcessController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MenuItemViewTest {

    private MenuItemView menuItemView;
    @Mock
    private StartProcessCommand startProcessCommand;
    @Mock
    private ProcessController processController;

    @BeforeEach
    public void setUp() {
        startProcessCommand = Mockito.mock(StartProcessCommand.class);
        processController = Mockito.mock(ProcessController.class);
        menuItemView = MenuItemView.create("Start", startProcessCommand);
    }

    @Test
    public void create01() {
        assertNull(MenuItemView.create(null, startProcessCommand));
    }

    @Test
    public void create02() {
        assertNull(MenuItemView.create("Start", null));
    }

    @Test
    public void create04() {
        assertNotNull(menuItemView);
    }

    @Test
    public void getMenuItem() {
        assertEquals(menuItemView.menuItem, menuItemView.getMenuItem());
    }
}