package gui.command;

import gui.controller.ChooseFileController;
import gui.model.ChooseFile;
import gui.model.ExecutableFile;
import gui.view.MainWindowView;
import gui.view.menubar.MenuBarView;

import java.io.File;

public class ChooseFileCommand extends CommandAbs {

    protected ExecutableFile executableFile;

    protected ChooseFileCommand() {
    }

    public static ChooseFileCommand create(ChooseFileController chooseFileController, ExecutableFile executableFile) {
        if (chooseFileController == null)
            return null;
        if (executableFile == null)
            return null;

        ChooseFileCommand chooseFileCommand = new ChooseFileCommand();
        chooseFileCommand.chooseFileController = chooseFileController;
        chooseFileCommand.executableFile = executableFile;
        return chooseFileCommand;
    }

    @Override
    public void execute() {
        try {
            File file = chooseFileController.getFileChooser().showOpenDialog(chooseFileController.getStage());
            if (chooseFileController.isValid(file)) {
                executableFile.setExecFile(file.getAbsolutePath());
                chooseFileController.chooseFileProcess();
            }
        } catch (final NullPointerException e) {
            e.printStackTrace();
        }
    }
}
