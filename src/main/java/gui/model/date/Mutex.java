package gui.model.date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Mutex extends MyData {

    protected SimpleStringProperty queue;
    protected String status;

    protected Mutex(String status, Integer threadId, String queue) {
        this.status = status;
        this.threadId = new SimpleIntegerProperty(threadId);
        this.queue = new SimpleStringProperty(queue);
    }

    protected Mutex(String status, Integer threadId, String address, String queue) {
        this.status = status;
        this.threadId = new SimpleIntegerProperty(threadId);
        this.address = new SimpleStringProperty(address);
        this.queue = new SimpleStringProperty(queue);
    }

    public static Mutex create(String line) {

        if (line == null)
            return null;

        Mutex mutex = null;

        if (line.toCharArray()[0] == '(') {
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            if (tokens.length == 2) {
                mutex = new Mutex((tokens[0].substring(1, tokens[0].length() - 1)), Integer.valueOf(tokens[1]), "");
            } else if (tokens.length == 3) {
                mutex = new Mutex((tokens[0].substring(1, tokens[0].length() - 1)), Integer.valueOf(tokens[1]), tokens[2], "");
            }
        }
        return mutex;
    }

    public String getAddress() {
        return address.get();
    }

    public String getQueue() {
        return queue.get();
    }

    public void setQueue(String queue) {
        this.queue.set(queue);
    }

    public String getStatus() {
        return status;
    }
}
