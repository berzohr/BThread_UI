package gui.view.menubar;

import javafx.scene.control.Menu;

public class MenuFactory {

    private static MenuFactory menuFactory;

    protected MenuFactory() {
    }

    public static MenuFactory instance() {
        if (menuFactory == null)
            menuFactory = new MenuFactory();
        return menuFactory;
    }

    public Menu createMenu(String menuName) {
        Menu menu = new Menu(menuName);
        menu.setText(menuName);
        menu.setId(menuName);
        return menu;
    }
}
