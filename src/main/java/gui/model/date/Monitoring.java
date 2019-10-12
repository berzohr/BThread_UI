package gui.model.date;

public class Monitoring {

    public boolean validateLine(String line) {

        if (line == null)
            return false;
        if (!line.startsWith("("))
            return false;

        return true;
    }
}
