package gui.mediator;

import gui.event.*;
import gui.view.SideButtonBar.SideButtonView;
import gui.view.menubar.MenuItemView;

import java.util.Observable;
import java.util.Observer;

public class MenuBarMediator implements Observer {

    protected MenuItemView startProcessMenuItem;
    protected MenuItemView pauseProcessMenuItem;
    protected MenuItemView stopProcessMenuItem;
    protected MenuItemView restartProcessItem;
    protected MenuItemView startMonitoringMenuItem;
    protected MenuItemView aboutWindowMenuItem;
    protected MenuItemView chooseFileMenuItem;

    protected SideButtonView startProcessSideButton;
    protected SideButtonView pauseProcessSideButton;
    protected SideButtonView stopProcessSideButton;
    protected SideButtonView restartProcessSideButton;
    protected SideButtonView startMonitoringSideButton;
    protected SideButtonView chooseFileSideButton;


    public static MenuBarMediator create() {
        MenuBarMediator menuBarMediator = new MenuBarMediator();
        return menuBarMediator;
    }

    public void setStartProcessMenuItem(MenuItemView startProcessMenuItem) {
        this.startProcessMenuItem = startProcessMenuItem;
    }

    public void setPauseProcessMenuItem(MenuItemView pauseProcessMenuItem) {
        this.pauseProcessMenuItem = pauseProcessMenuItem;
    }

    public void setStopProcessMenuItem(MenuItemView stopProcessMenuItem) {
        this.stopProcessMenuItem = stopProcessMenuItem;
    }

    public void setRestartProcessItem(MenuItemView restartProcessItem) {
        this.restartProcessItem = restartProcessItem;
    }

    public void setStartMonitoringMenuItem(MenuItemView startMonitoringMenuItem) {
        this.startMonitoringMenuItem = startMonitoringMenuItem;
    }

    public void setChooseFileMenuItem(MenuItemView chooseFileMenuItem) {
        this.chooseFileMenuItem = chooseFileMenuItem;
    }

    public void setAboutWindow(MenuItemView aboutWindow) {
        this.aboutWindowMenuItem = aboutWindow;
    }

    public void setStartProcessSideButton(SideButtonView startProcessSideButton) {
        this.startProcessSideButton = startProcessSideButton;
    }

    public void setPauseProcessSideButton(SideButtonView pauseProcessSideButton) {
        this.pauseProcessSideButton = pauseProcessSideButton;
    }

    public void setStopProcessSideButton(SideButtonView stopProcessSideButton) {
        this.stopProcessSideButton = stopProcessSideButton;
    }

    public void setRestartProcessSideButton(SideButtonView restartProcessSideButton) {
        this.restartProcessSideButton = restartProcessSideButton;
    }

    public void setStartMonitoringSideButton(SideButtonView startMonitoringSideButton) {
        this.startMonitoringSideButton = startMonitoringSideButton;
    }

    public void setChooseFileSideButton(SideButtonView chooseFileSideButton) {
        this.chooseFileSideButton = chooseFileSideButton;
    }

    private void itemSetting() {
        startProcessMenuItem.getMenuItem().setDisable(true);
        pauseProcessMenuItem.getMenuItem().setDisable(false);
        stopProcessMenuItem.getMenuItem().setDisable(false);
        restartProcessItem.getMenuItem().setDisable(false);
        startMonitoringMenuItem.getMenuItem().setDisable(false);
        chooseFileMenuItem.getMenuItem().setDisable(true);

        startProcessSideButton.getSideButton().setDisable(true);
        pauseProcessSideButton.getSideButton().setDisable(false);
        stopProcessSideButton.getSideButton().setDisable(false);
        restartProcessSideButton.getSideButton().setDisable(false);
        startMonitoringSideButton.getSideButton().setDisable(false);
        chooseFileSideButton.getSideButton().setDisable(true);
    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof StartEvent) {
            itemSetting();
        } else if (event instanceof StopEvent) {
            startProcessMenuItem.getMenuItem().setDisable(false);
            pauseProcessMenuItem.getMenuItem().setDisable(true);
            stopProcessMenuItem.getMenuItem().setDisable(true);
            restartProcessItem.getMenuItem().setDisable(true);
            startMonitoringMenuItem.getMenuItem().setDisable(true);
            chooseFileMenuItem.getMenuItem().setDisable(false);

            startProcessSideButton.getSideButton().setDisable(false);
            pauseProcessSideButton.getSideButton().setDisable(true);
            stopProcessSideButton.getSideButton().setDisable(true);
            restartProcessSideButton.getSideButton().setDisable(true);
            startMonitoringSideButton.getSideButton().setDisable(true);
            chooseFileSideButton.getSideButton().setDisable(false);
        } else if (event instanceof MonitoringStartedEvent) {
            itemSetting();
        } else if (event instanceof PauseEvent) {
            itemSetting();
        } else if (event instanceof RestartEvent) {
            itemSetting();
        } else if (event instanceof ChooseFileEvent) {
            startProcessMenuItem.getMenuItem().setDisable(false);
            startProcessSideButton.getSideButton().setDisable(false);
        }
    }
}