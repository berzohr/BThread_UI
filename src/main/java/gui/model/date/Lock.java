package gui.model.date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lock extends MyData {

    protected Lock(String status, Integer threadId) {
        this.threadId = new SimpleIntegerProperty(threadId);
        this.status = new SimpleStringProperty(status);
    }

    public static Lock create(String line) {
        if (line == null)
            return null;

        Lock lock = null;

        if (line.toCharArray()[0] == '(') {
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            if (tokens.length > 1) {
                lock = new Lock((tokens[0].substring(1, tokens[0].length() - 1)), Integer.valueOf(tokens[1]));
            }
        }
        return lock;
    }
}