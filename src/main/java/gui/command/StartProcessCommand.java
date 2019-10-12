package gui.command;

import gui.controller.ProcessController;
import gui.model.ExecutableFile;

import java.io.IOException;


public class StartProcessCommand extends CommandAbs {

    protected ExecutableFile executableFile;

    protected StartProcessCommand() {
    }

    public static StartProcessCommand create(ProcessController receiver, ExecutableFile executableFile) {
        if (receiver == null)
            return null;
        if (executableFile == null)
            return null;

        StartProcessCommand command = new StartProcessCommand();
        command.receiver = receiver;
        command.executableFile = executableFile;

        return command;
    }

    @Override
    public void execute() throws IOException {
        if (executableFile.getExecFile() != null) {
            receiver.startProcess(initProcess(executableFile.getExecFile()), executableFile.getExecFile());
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
}

