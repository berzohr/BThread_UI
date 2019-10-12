package gui.mediator;

import gui.view.JavaFXInitTest;
import gui.view.SideButtonBar.SideButtonView;
import gui.view.menubar.MenuItemView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MenuBarMediatorTest {

    private MenuItemView startProcessMenuItem;
    private MenuItemView pauseProcessMenuItem;
    private MenuItemView stopProcessMenuItem;
    private MenuItemView startMonitoringMenuItem;
    private MenuItemView restartProcessMenuItem;
    private MenuItemView aboutWindowItem;
    private MenuItemView chooseFileMenuItem;

    private MenuBarMediator menuBarMediator;

    @Before
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();

        menuBarMediator = MenuBarMediator.create();
        startProcessMenuItem = Mockito.mock(MenuItemView.class);
        pauseProcessMenuItem = Mockito.mock(MenuItemView.class);
        stopProcessMenuItem = Mockito.mock(MenuItemView.class);
        startMonitoringMenuItem = Mockito.mock(MenuItemView.class);
        restartProcessMenuItem = Mockito.mock(MenuItemView.class);
        aboutWindowItem = Mockito.mock(MenuItemView.class);
        chooseFileMenuItem = Mockito.mock(MenuItemView.class);
    }

    @Test
    public void create() {
        assertNotNull(menuBarMediator);
    }

    @Test
    public void setStartProcessMenuItem() {
        menuBarMediator.setStartProcessMenuItem(startProcessMenuItem);
        assertEquals(menuBarMediator.startProcessMenuItem, startProcessMenuItem);

    }

    @Test
    public void setPauseProcessMenuItem() {
        menuBarMediator.setPauseProcessMenuItem(pauseProcessMenuItem);
        assertEquals(menuBarMediator.pauseProcessMenuItem, pauseProcessMenuItem);

    }

    @Test
    public void setStopProcessMenuItem() {
        menuBarMediator.setStopProcessMenuItem(stopProcessMenuItem);
        assertEquals(menuBarMediator.stopProcessMenuItem, stopProcessMenuItem);
    }

    @Test
    public void setStartMonitoringMenuItem() {
        menuBarMediator.setStartMonitoringMenuItem(startMonitoringMenuItem);
        assertEquals(menuBarMediator.startMonitoringMenuItem, startMonitoringMenuItem);
    }

    @Test
    public void setRestartProcessItem() {
        menuBarMediator.setRestartProcessItem(restartProcessMenuItem);
        assertEquals(menuBarMediator.restartProcessItem, restartProcessMenuItem);
    }

    @Test
    public void setAboutWindow() {
        menuBarMediator.setRestartProcessItem(aboutWindowItem);
        assertEquals(menuBarMediator.restartProcessItem, aboutWindowItem);
    }

    @Test
    public void itemSetting() {
//        Observable observable = Mockito.mock(Observable.class);
//        StartEvent startEvent = Mockito.mock(StartEvent.class);
//        MenuItemView startProcessMenuItem = MenuItemView.create("Start", Mockito.mock(StartProcessCommand.class),
//                Mockito.mock(ProcessController.class));
//        menuBarMediator.setStartProcessMenuItem(startProcessMenuItem);
//        menuBarMediator.setPauseProcessMenuItem(pauseProcessMenuItem);
//        menuBarMediator.update(observable, startEvent);
    }

    @Test
    public void update() {
    }
}