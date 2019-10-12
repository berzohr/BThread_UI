package gui.command;

import gui.controller.ExitController;

public class ExitCommand extends CommandAbs {

    protected ExitCommand() {
    }

    public static ExitCommand create(ExitController exitController) {
        if (exitController == null)
            return null;

        ExitCommand exitCommand = new ExitCommand();
        exitCommand.exitController = exitController;
        return exitCommand;
    }

    @Override
    public void execute() {
        exitController.exitProcess();
        exitController.closeStage();
    }
}
