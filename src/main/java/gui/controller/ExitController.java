package gui.controller;

import gui.interfaces.ExitManager;
import javafx.stage.Stage;

public class ExitController extends Controller implements ExitManager {

    protected Stage stage;
    protected ExitManager receiver;

    protected ExitController() {
    }

    public static ExitController create(ExitManager receiver) {

        if (receiver == null)
            return null;

        ExitController exitController = new ExitController();
        exitController.receiver = receiver;
        return exitController;
    }

    @Override
    public void exitProcess() {
        receiver.exitProcess();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }
}
