package gui.view.menubar;

import gui.command.CommandAbs;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.io.IOException;

public class MenuItemView {

    protected MenuItem menuItem;

    protected MenuItemView() {
    }

    public static MenuItemView create(String itemName, final CommandAbs command) {
        if (itemName == null)
            return null;
        if (command == null)
            return null;

        MenuItemView menuItemView = new MenuItemView();
        menuItemView.menuItem = new MenuItem(itemName);
        menuItemView.menuItem.setId(itemName.replace(" ", ""));
        System.out.println(menuItemView.menuItem.getId());
        menuItemView.menuItem.setAccelerator(new KeyCodeCombination(KeyCode.getKeyCode(itemName.substring(0, 1)), KeyCombination.CONTROL_ANY));
        menuItemView.menuItem.setOnAction(e -> {
            try {
                command.execute();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        return menuItemView;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
}
