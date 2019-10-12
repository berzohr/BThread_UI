package gui.model.date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Gantt extends MyData {

    protected Gantt(String status, Integer threadId) {
        this.status = new SimpleStringProperty(status);
        this.threadId = new SimpleIntegerProperty(threadId);
    }

    public static Gantt create(String line) {
        if (line == null)
            return null;

        Gantt gantt = null;
        if (line.toCharArray()[0] == '(') {
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            if (tokens.length > 1) {
                gantt = new Gantt((tokens[0].substring(1, tokens[0].length() - 1)), Integer.valueOf(tokens[1]));
            }
        }
        return gantt;
    }

}
