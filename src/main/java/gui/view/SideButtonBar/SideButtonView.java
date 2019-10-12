package gui.view.SideButtonBar;

import gui.command.CommandAbs;
import javafx.scene.control.Button;

import java.io.IOException;

public class SideButtonView {

    protected Button button;

    protected SideButtonView() {
    }

    public static SideButtonView create(String styleClassName, CommandAbs command) {

        if (styleClassName == null)
            return null;
        if (command == null)
            return null;

        SideButtonView sideButtonView = new SideButtonView();
        sideButtonView.button = new Button();
        sideButtonView.button.setId(styleClassName);
        sideButtonView.button.getStyleClass().add(styleClassName);
        sideButtonView.button.setOnAction(e -> {
            try {
                command.execute();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        return sideButtonView;
    }

    public Button getSideButton() {
        return button;
    }
}
