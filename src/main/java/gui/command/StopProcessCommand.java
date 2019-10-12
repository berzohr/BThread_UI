package gui.command;

import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import gui.singleton.MainProcess;

public class StopProcessCommand extends CommandAbs {

    protected ExecutableFile executableFile;

    protected StopProcessCommand() {
    }

    public static StopProcessCommand create(ProcessController receiver, ExecutableFile executableFile) {
        if (receiver == null)
            return null;
        if (executableFile == null)
            return null;

        StopProcessCommand command = new StopProcessCommand();
        command.receiver = receiver;
        command.executableFile = executableFile;

        return command;
    }

    @Override
    public void execute() {
        if (executableFile.getExecFile() != null)
            receiver.stopProcess(stopProcess(), executableFile.getExecFile());
    }

    protected Process stopProcess() {
        Process process = MainProcess.getMainProcess().getCurrentProcess();
        if (process != null) {
            return process;
        } else {
            return null;
        }
    }
}

