package gui.model.date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Barrier extends MyData {

    protected SimpleIntegerProperty size;
    protected SimpleIntegerProperty counter;
    protected SimpleStringProperty queue;

    protected Barrier(String status, String address, Integer counter, Integer size, String queue) {
        this.status = new SimpleStringProperty(status);
        this.address = new SimpleStringProperty(address);
        this.counter = new SimpleIntegerProperty(counter);
        this.size = new SimpleIntegerProperty(size);
        this.queue = new SimpleStringProperty(queue);
    }

    protected Barrier(String status, Integer threadId, String address, Integer counter, Integer size, String queue) {
        this.status = new SimpleStringProperty(status);
        this.threadId = new SimpleIntegerProperty(threadId);
        this.address = new SimpleStringProperty(address);
        this.counter = new SimpleIntegerProperty(counter);
        this.size = new SimpleIntegerProperty(size);
        this.queue = new SimpleStringProperty(queue);
    }


    public static Barrier create(String line) {

        if (line == null)
            return null;

        Barrier barrier = null;
        if (line.toCharArray()[0] == '(') {
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            if (tokens.length == 4) {
                barrier = new Barrier((tokens[0].substring(1, tokens[0].length() - 1)), tokens[1], Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]), "");
            } else if (tokens.length == 5) {
                barrier = new Barrier((tokens[0].substring(1, tokens[0].length() - 1)), Integer.valueOf(tokens[1]), tokens[2], Integer.valueOf(tokens[3]), Integer.valueOf(tokens[4]), "");
            }
        }
        return barrier;
    }

    public int getSize() {
        return size.get();
    }

    public void setSize(int size) {
        this.size.set(size);
    }

    public int getCounter() {
        return counter.get();
    }

    public void setCounter(int counter) {
        this.counter.set(counter);
    }

    public String getQueue() {
        return queue.get();
    }

    public void setQueue(String queue) {
        this.queue.set(queue);
    }
}

