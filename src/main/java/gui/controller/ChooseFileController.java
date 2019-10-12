package gui.controller;

import gui.interfaces.ChooserFileManager;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ChooseFileController extends Controller implements ChooserFileManager {

    protected Stage stage;
    protected ChooserFileManager receiver;
    protected FileChooser fileChooser;

    protected ChooseFileController() {
    }

    public static ChooseFileController create(Stage stage, ChooserFileManager receiver) {
        if (stage == null)
            return null;
        if (receiver == null)
            return null;

        ChooseFileController chooseFileController = new ChooseFileController();
        chooseFileController.stage = stage;
        chooseFileController.receiver = receiver;
        chooseFileController.fileChooser = new FileChooser();
        return chooseFileController;
    }

    public boolean isValid(final File file) {
        if(file == null) return false;
        boolean eseguibile = file.canExecute();
        boolean fileValido = file.canRead();

        if (!eseguibile) {
            throw new IllegalArgumentException("non eseguibile");
        }
        if (!fileValido) {
            throw new IllegalArgumentException("non file");
        }
        return true;
    }

    @Override
    public void chooseFileProcess() {
        receiver.chooseFileProcess();
    }

    public Stage getStage() {
        return stage;
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }
}