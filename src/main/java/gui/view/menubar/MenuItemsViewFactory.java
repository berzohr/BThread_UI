package gui.view.menubar;

import gui.command.CommandAbs;
import gui.controller.Controller;


public class MenuItemsViewFactory {

    private static MenuItemsViewFactory menuItemsViewFactory;

    protected MenuItemsViewFactory() {
    }

    public static MenuItemsViewFactory instance() {
        if (menuItemsViewFactory == null)
            menuItemsViewFactory = new MenuItemsViewFactory();
        return menuItemsViewFactory;
    }

    public MenuItemView createMenuItem(String itemName, final CommandAbs command) {
        MenuItemView menuItemView = MenuItemView.create(itemName, command);
        return menuItemView;
    }
}
