package gui.command;

import gui.controller.ProcessController;
import gui.model.ExecutableFile;
import gui.singleton.MainProcess;

import java.io.IOException;

public class RestartProcessCommand extends CommandAbs {

    protected ExecutableFile executableFile;

    protected RestartProcessCommand() {
    }

    public static RestartProcessCommand create(ProcessController receiver, ExecutableFile executableFile) {
        if (receiver == null)
            return null;
        if (executableFile == null)
            return null;

        RestartProcessCommand command = new RestartProcessCommand();
        command.receiver = receiver;
        command.executableFile = executableFile;

        return command;
    }

    @Override
    public void execute() {
        if (getProcess() != null) {
            receiver.restartProcess(getProcess(), initProcess(executableFile.getExecFile()), executableFile.getExecFile());
        }
    }

    protected Process initProcess(String fileName) {
        Runtime rt = Runtime.getRuntime();
        try {
            Process process = rt.exec(fileName);
            return process;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected Process getProcess() {
        return MainProcess.getMainProcess().getCurrentProcess();
    }
}