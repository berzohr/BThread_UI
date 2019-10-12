package gui.model.date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Status extends MyData {

    protected Status(String status, Integer threadId) {
        this.status = new SimpleStringProperty(status);
        this.threadId = new SimpleIntegerProperty(threadId);
    }

    public static Status create(String line) {
        if (line == null)
            return null;

        Status status = null;
        if (line.toCharArray()[0] == '(') {
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            if (tokens.length > 1) {
                try {
                    status = new Status((tokens[0].substring(1, tokens[0].length() - 1)), Integer.valueOf(tokens[1]));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}