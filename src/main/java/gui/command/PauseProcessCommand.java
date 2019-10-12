package gui.command;

import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import gui.singleton.MainProcess;

public class PauseProcessCommand extends CommandAbs {

    protected PauseProcessCommand() {
    }

    public static PauseProcessCommand create(ProcessController receiver, ExecutableFile executableFile) {
        if (receiver == null)
            return null;

        if (executableFile == null)
            return null;

        PauseProcessCommand command = new PauseProcessCommand();
        command.receiver = receiver;
        command.executableFile = executableFile;

        return command;
    }

    @Override
    public void execute() {
        if (executableFile.getExecFile() != null) {
            receiver.pauseProcess(getProcess(), executableFile.getExecFile());
        }
    }

    private Process getProcess() {
        return MainProcess.getMainProcess().getCurrentProcess();
    }

}
