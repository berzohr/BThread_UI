package gui.event.myDataEvent;

import gui.model.date.MyDataFactory;

public class GanttEvent extends MyDataEvent {

    protected GanttEvent() {
    }

    public static GanttEvent create(String line) {

        if (line == null)
            return null;

        GanttEvent ganttEvent = new GanttEvent();
        ganttEvent.data = MyDataFactory.create("Gantt", line);
        return ganttEvent;
    }
}
