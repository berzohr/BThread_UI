package gui.controller;

import gui.interfaces.AboutWindowManager;
import javafx.stage.Stage;

public class AboutWindowController extends Controller implements AboutWindowManager {

    private Stage stage;
    private AboutWindowManager aboutWindowReceiver;

    protected AboutWindowController() {
    }

    public static AboutWindowController create(Stage stage, AboutWindowManager aboutWindowReceiver) {

        if (stage == null)
            return null;

        if (aboutWindowReceiver == null)
            return null;

        AboutWindowController aboutWindowController = new AboutWindowController();
        aboutWindowController.stage = stage;
        aboutWindowController.aboutWindowReceiver = aboutWindowReceiver;
        return aboutWindowController;
    }

    @Override
    public void aboutWindow() {
        aboutWindowReceiver.aboutWindow();
    }
}
