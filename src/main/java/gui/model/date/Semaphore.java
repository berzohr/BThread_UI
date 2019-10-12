package gui.model.date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Semaphore extends MyData {

    protected SimpleStringProperty queue;
    protected SimpleIntegerProperty counter;

    protected Semaphore(String status, Integer threadId, String queue) {
        this.status = new SimpleStringProperty(status);
        this.threadId = new SimpleIntegerProperty(threadId);
        this.queue = new SimpleStringProperty(queue);
    }

    protected Semaphore(String status, Integer threadId, String address, Integer counter, String queue) {
        this.status = new SimpleStringProperty(status);
        this.threadId = new SimpleIntegerProperty(threadId);
        this.address = new SimpleStringProperty(address);
        this.counter = new SimpleIntegerProperty(counter);
        this.queue = new SimpleStringProperty(queue);
    }


    public static Semaphore create(String line) {

        if (line == null)
            return null;

        Semaphore semaphore = null;
        if (line.toCharArray()[0] == '(') {
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            if (tokens.length == 2) {
                semaphore = new Semaphore((tokens[0].substring(1, tokens[0].length() - 1)), Integer.valueOf(tokens[1]), "");
            } else if (tokens.length == 4) {
                semaphore = new Semaphore((tokens[0].substring(1, tokens[0].length() - 1)),
                        Integer.valueOf(tokens[1]), tokens[2], Integer.valueOf(tokens[3]), "");
            }
        }
        return semaphore;
    }

    public String getQueue() {
        return queue.get();
    }

    public void setQueue(String queue) {
        this.queue.set(queue);
    }

    public int getCounter() {
        return counter.get();
    }

    public void setCounter(int counter) {
        this.counter.set(counter);
    }
}
