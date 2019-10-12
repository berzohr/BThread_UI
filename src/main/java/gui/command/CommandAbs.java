package gui.command;

import gui.controller.AboutWindowController;
import gui.controller.ChooseFileController;
import gui.controller.ExitController;
import gui.controller.ProcessController;
import gui.interfaces.Command;
import gui.model.ExecutableFile;

public abstract class CommandAbs implements Command {

    protected ProcessController receiver;
    protected AboutWindowController aboutWindowController;
    protected ExitController exitController;
    protected ChooseFileController chooseFileController;
    protected ExecutableFile executableFile;

}
