package gui.singleton;

public class MainProcess {

    protected Process currentProcess;
    protected static final MainProcess istance = new MainProcess();

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public static MainProcess getMainProcess() {
        return istance;
    }

    public void setCurrentProcess(Process currentProcess) {
        this.currentProcess = currentProcess;
    }
}
