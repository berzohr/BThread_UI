package gui.model;

import gui.event.NewLineReadEvent;
import gui.model.date.Monitoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

public class OutputProcessingThread extends Observable implements Runnable {

    protected AtomicBoolean isMonitoring = new AtomicBoolean(false);
    protected Process process;
    protected Parser parser;
    protected Monitoring monitoring;

    protected OutputProcessingThread() {
    }

    public static OutputProcessingThread create(final Parser parser, Monitoring monitoring) {
        if (parser == null)
            return null;
        if (monitoring == null)
            return null;

        OutputProcessingThread outputProcessingThread = new OutputProcessingThread();
        outputProcessingThread.parser = parser;
        outputProcessingThread.monitoring = monitoring;
        return outputProcessingThread;
    }


    @Override
    public void run() {
        monitoring = new Monitoring();
        InputStream input = process.getInputStream();
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                Thread.sleep(40);
                parser.parsing(line);
                if (monitoring.validateLine(line)) {
                    if (isMonitoring.get()) {
                        this.setChanged();
                        notifyObservers(new NewLineReadEvent(line + "\n"));
                    }
                }
            }
            input.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    void setIsMonitoring(boolean flag) {
        isMonitoring.set(flag);
    }
}
