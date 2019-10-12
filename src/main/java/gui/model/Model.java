package gui.model;

import gui.event.*;
import gui.interfaces.ProcessManager;
import gui.model.date.*;
import gui.singleton.MainProcess;
import gui.view.MainWindowView;
import gui.view.ganttchart.GantChartInitialize;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Observable;

public class Model extends Observable implements ProcessManager {

    protected OutputProcessingThread opt;
    protected static Model model;
    protected Thread tableThread;
    protected Parser parser;
    protected ObservableList<Status> statusList;
    private ObservableList<Lock> lockList;
    protected ObservableList<Mutex> mutexList;
    protected ObservableList<Semaphore> semaphoreList;
    protected ObservableList<Barrier> barrierList;
    protected ObservableList<Condition> conditionList;
    protected ObservableList<Gantt> ganttList;

    protected volatile boolean pause = false;

    protected Model() {
    }

    //singleton
    public static Model create(Parser parser, OutputProcessingThread opt, ObservableList<Status> statusList, ObservableList<Lock> lockList, ObservableList<Mutex> mutexList, ObservableList<Semaphore> semaphoreList,
                               ObservableList<Barrier> barrierList, ObservableList<Condition> conditionList, ObservableList<Gantt> ganttList) {

        if (parser == null)
            return null;
        if (opt == null)
            return null;
        if (statusList == null)
            return null;
        if (lockList == null)
            return null;
        if (mutexList == null)
            return null;
        if (semaphoreList == null)
            return null;
        if (barrierList == null)
            return null;
        if (conditionList == null)
            return null;
        if (ganttList == null)
            return null;

        if (model == null) {
            model = new Model();
            model.parser = parser;
            model.statusList = statusList;
            model.lockList = lockList;
            model.mutexList = mutexList;
            model.semaphoreList = semaphoreList;
            model.barrierList = barrierList;
            model.conditionList = conditionList;
            model.ganttList = ganttList;
            model.opt = opt;
        }
        return model;
    }

    @Override
    public void startProcess(Process initProcess, String filename) throws IOException {
        if (MainProcess.getMainProcess().getCurrentProcess() == null) {
            MainProcess.getMainProcess().setCurrentProcess(initProcess);
            clearList();
            opt.setProcess(initProcess);
            tableThread = new Thread(opt);
            tableThread.setDaemon(false);
            tableThread.start();
            this.setChanged();
            notifyObservers(new StartEvent(filename));
            this.setChanged();
            notifyObservers(new NewGantProcess());

        } else {
            throw new IOException("start process is not null");
        }
    }


    @Override
    public void stopProcess(Process startedProcess, String filename) {
        startedProcess.destroyForcibly();
        MainProcess.getMainProcess().setCurrentProcess(null);
        opt.setIsMonitoring(false);
        try {
            tableThread.join();
            this.setChanged();
            notifyObservers(new StopEvent(filename));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startMonitoring(Process startedProcess) {
        if (startedProcess != null) {
            opt.setIsMonitoring(true);
            setChanged();
            notifyObservers(new MonitoringStartedEvent());
        }
    }

    @Override
    public void pauseProcess(Process startedProcess, String filename) {
        if (startedProcess != null) {
            boolean isWindows = (System.getProperty("os.name").substring(0, 7).equals("Windows")) ? true : false;
            boolean isX86 = (System.getProperty("os.arch")).equals("x86") ? true : false;
            long pid = 0;

            if (isWindows) {
                URL url;
                if (isX86) {
                    url = this.getClass().getClassLoader().getResource("NtSuspendProcess64.exe");
                } else {
                    url = this.getClass().getClassLoader().getResource("NtSuspendProcess.exe");
                }

                String processString = null;

                try {
                    Process taskListProcess = Runtime.getRuntime().exec("tasklist");
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(taskListProcess.getInputStream()));
                    StringBuilder builder = new StringBuilder();

                    String[] filenameArray = filename.split("\\\\");
                    String fname = filenameArray[filenameArray.length - 1];

                    while ((processString = stdInput.readLine()) != null) {
                        if (processString.contains(fname)) {
                            String[] arr = processString.split("\\s+");
                            System.out.println("pid: " + arr[1]);
                            pid = Long.parseLong(arr[1]);

                        }
                    }
                    taskListProcess.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

                String cmd;
                if (!pause) {
                    cmd = "-pid " + pid;
                    pause = true;
                } else {
                    cmd = "-rpid " + pid;
                    pause = false;
                }
                ProcessBuilder processBuilder = new ProcessBuilder(url.getFile(), cmd);
                System.out.println(">>>>DEBUG: " + isWindows + " / " + isX86 + " / pid: " + pid);


                try {
                    processBuilder.start();
                    this.setChanged();
                    if (pause) {
                        this.notifyObservers(new PauseEvent("Stopped PID-" + Long.toString(pid)));
                    } else {
                        this.notifyObservers(new PauseEvent("Restore PID-" + Long.toString(pid)));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void restartProcess(Process startedProcess, Process newProcess, String filename) {
        startedProcess.destroyForcibly();
        MainProcess.getMainProcess().setCurrentProcess(null);
        try {
            tableThread.join();
            startProcess(newProcess, filename);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clearList() {
        statusList.clear();
        lockList.clear();
        mutexList.clear();
        semaphoreList.clear();
        barrierList.clear();
        conditionList.clear();
        ganttList.clear();
    }
}
