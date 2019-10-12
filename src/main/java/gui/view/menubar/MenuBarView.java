package gui.view.menubar;

import gui.command.*;
import gui.controller.AboutWindowController;
import gui.controller.ChooseFileController;
import gui.controller.ExitController;
import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;

public class MenuBarView {

    protected MenuItemView startItemMenu;
    protected MenuItemView pauseItemMenu;
    protected MenuItemView stopItemMenu;
    protected MenuItemView startMonitoringItemMenu;
    protected MenuItemView restartItemMenu;
    protected MenuItemView aboutItemMenu;
    protected MenuItemView chooseFileItemMenu;
    protected MenuBar menuBar;

    protected MenuBarView() {
    }


    public static MenuBarView create(final ProcessController controller, final AboutWindowController aboutWindowController, final ExitController exitController,
                                     final ChooseFileController chooseFileController, final ExecutableFile executableFile) {

        if (controller == null)
            return null;
        if (aboutWindowController == null)
            return null;
        if (exitController == null)
            return null;
        if (chooseFileController == null)
            return null;
        if (executableFile == null)
            return null;

        MenuBarView menuBarView = new MenuBarView();
        menuBarView.menuBar = new MenuBar();

        //FILE MENU
        menuBarView.chooseFileItemMenu = MenuItemView.create("Open File", ChooseFileCommand.create(chooseFileController, executableFile));
        MenuItemView exitItemMenu = MenuItemsViewFactory.instance().createMenuItem("Exit", ExitCommand.create(exitController));

        Menu fileMenu = MenuFactory.instance().createMenu("File");
        fileMenu.getItems().addAll(menuBarView.chooseFileItemMenu.getMenuItem(), exitItemMenu.getMenuItem());
        //THREAD MENU

        menuBarView.startItemMenu = MenuItemsViewFactory.instance().createMenuItem("Start", StartProcessCommand.create(controller, executableFile));
        menuBarView.pauseItemMenu = MenuItemsViewFactory.instance().createMenuItem("Pause", PauseProcessCommand.create(controller, executableFile));
        menuBarView.startMonitoringItemMenu = MenuItemsViewFactory.instance().createMenuItem("Monitoring", StartMonitoringCommand.create(controller));
        menuBarView.stopItemMenu = MenuItemsViewFactory.instance().createMenuItem("Stop", StopProcessCommand.create(controller, executableFile));
        menuBarView.restartItemMenu = MenuItemsViewFactory.instance().createMenuItem("Restart", RestartProcessCommand.create(controller, executableFile));

        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();

        Menu threadMenu = MenuFactory.instance().createMenu("Thread");
        threadMenu.getItems().addAll(menuBarView.startItemMenu.getMenuItem(), menuBarView.pauseItemMenu.getMenuItem(), menuBarView.stopItemMenu.getMenuItem(),
                separatorMenuItem1, menuBarView.restartItemMenu.getMenuItem(), separatorMenuItem2, menuBarView.startMonitoringItemMenu.getMenuItem());

        //HELP MENU
        menuBarView.aboutItemMenu = MenuItemsViewFactory.instance().createMenuItem("About", AboutCommand.create(aboutWindowController));
        Menu helpMenu = new Menu("Help");
        helpMenu.setId("Help");
        helpMenu.getItems().addAll(menuBarView.aboutItemMenu.getMenuItem());


        menuBarView.menuBar.getMenus().addAll(fileMenu, threadMenu, helpMenu);
        return menuBarView;
    }

    public MenuBar getMenu() {
        return menuBar;
    }

    public MenuItemView getStartProcessItemMenu() {
        return startItemMenu;
    }

    public MenuItemView getStopProcessItemMenu() {
        return stopItemMenu;
    }

    public MenuItemView getStartMonitoringItemMenu() {
        return startMonitoringItemMenu;
    }

    public MenuItemView getRestartItemMenu() {
        return restartItemMenu;
    }

    public MenuItemView getPauseItemMenu() {
        return pauseItemMenu;
    }

    public MenuItemView getWindowItemMenu() {
        return aboutItemMenu;
    }

    public MenuItemView getChooseFileItemMenu() {
        return chooseFileItemMenu;
    }
}
