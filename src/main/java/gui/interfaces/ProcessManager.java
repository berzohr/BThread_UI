package gui.interfaces;

import java.io.IOException;

public interface ProcessManager {

    void startProcess(Process initProcess, String filename) throws IOException;

    void stopProcess(Process startedProcess, String filename);

    void startMonitoring(Process startedProcess);

    void pauseProcess(Process startedProcess, String filename);

    void restartProcess(Process startedProcess, Process newProcess, String filename);
}
