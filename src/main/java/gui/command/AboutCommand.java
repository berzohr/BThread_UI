package gui.command;

import gui.controller.AboutWindowController;

public class AboutCommand extends CommandAbs {

    protected AboutCommand() {
    }

    public static AboutCommand create(AboutWindowController aboutWindowController) {

        if (aboutWindowController == null)
            return null;

        AboutCommand aboutCommand = new AboutCommand();
        aboutCommand.aboutWindowController = aboutWindowController;
        return aboutCommand;
    }

    @Override
    public void execute() {
        aboutWindowController.aboutWindow();
    }

}
