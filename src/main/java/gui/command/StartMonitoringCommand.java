package gui.command;

import gui.controller.ProcessController;
import gui.singleton.MainProcess;

public class StartMonitoringCommand extends CommandAbs {

    protected StartMonitoringCommand() {
    }

    public static StartMonitoringCommand create(ProcessController receiver) {
        if (receiver == null)
            return null;

        StartMonitoringCommand command = new StartMonitoringCommand();
        command.receiver = receiver;

        return command;
    }

    @Override
    public void execute() {
        receiver.startMonitoring(getProcess());
    }

    protected Process getProcess() {
        return MainProcess.getMainProcess().getCurrentProcess();
    }
}
