package gui.controller;

import gui.interfaces.ProcessManager;

import java.io.IOException;

public class ProcessController extends Controller implements ProcessManager {

    private ProcessManager model;

    protected ProcessController() {
    }

    public static ProcessController create(ProcessManager model) {
        if (model == null) {
            return null;
        }

        ProcessController controller = new ProcessController();
        controller.model = model;

        return controller;
    }

    @Override
    public void startProcess(Process processName, String filename) throws IOException {
        model.startProcess(processName, filename);
    }

    @Override
    public void stopProcess(Process startedProcess, String filename) {
        model.stopProcess(startedProcess, filename);
    }

    @Override
    public void startMonitoring(Process startedProcess) {
        model.startMonitoring(startedProcess);
    }

    public void pauseProcess(Process startedProcess, String filename) {
        model.pauseProcess(startedProcess, filename);
    }

    @Override
    public void restartProcess(Process startedProcess, Process newProcess, String filename) {
        model.restartProcess(startedProcess, newProcess, filename);
    }
}
