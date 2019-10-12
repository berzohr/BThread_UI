package gui.model;

import gui.event.myDataEvent.MyDataEventFactory;

import java.util.Observable;

public class Parser extends Observable {

    protected OutputString StringMatching(String line) {

        String discriminated = line.substring(1, 4);
        String result = null;

        if (discriminated.equalsIgnoreCase("MUT")) {
            result = "Mutex";
        } else if (discriminated.equalsIgnoreCase("SEM")) {
            result = "Semaphore";
        } else if (discriminated.equalsIgnoreCase("BAR")) {
            result = "Barrier";
        } else if (discriminated.equalsIgnoreCase("CON")) {
            result = "Condition";
        } else if (discriminated.equalsIgnoreCase("SCH")) {
            result = "Lock";
        }

        OutputString outputString = new OutputString(result + "Event", "StatusEvent", "GanttEvent");

        return outputString;
    }

    public void parsing(String line) {

        if (line == null)
            return;

        if (!line.startsWith("("))
            return;

        OutputString outputString = StringMatching(line);

        if (!outputString.getParam1().equalsIgnoreCase("nullEvent")) {
            this.setChanged();
            notifyObservers(MyDataEventFactory.create(outputString.getParam1(), line));
        }
        this.setChanged();
        notifyObservers(MyDataEventFactory.create(outputString.getParam2(), line));
        this.setChanged();
        notifyObservers(MyDataEventFactory.create(outputString.getParam3(), line));
    }
}
