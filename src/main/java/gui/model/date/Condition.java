package gui.model.date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Condition extends MyData {

    protected SimpleStringProperty queue;

    protected Condition(String status, Integer threadId, String address, String queue) {
        this.status = new SimpleStringProperty(status);
        this.threadId = new SimpleIntegerProperty(threadId);
        this.address = new SimpleStringProperty(address);
        this.queue = new SimpleStringProperty(queue);
    }

    public static Condition create(String line) {

        if (line == null)
            return null;

        Condition condition = null;
        if (line.toCharArray()[0] == '(') {
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            if (tokens.length == 3) {
                condition = new Condition((tokens[0].substring(1, tokens[0].length() - 1)), Integer.valueOf(tokens[1]), tokens[2], "");
            }
        }
        return condition;
    }

    public String getQueue() {
        return queue.get();
    }

    public void setQueue(String queue) {
        this.queue.set(queue);
    }
}
