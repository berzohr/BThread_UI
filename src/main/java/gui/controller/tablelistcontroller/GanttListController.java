package gui.controller.tablelistcontroller;

import gui.event.GanttEventScheduling;
import gui.event.GanttThreadEvent;
import gui.model.date.Gantt;
import gui.model.date.datamodel.GanttModel;


import java.util.Observable;

public class GanttListController extends Observable {

    protected GanttModel ganttModel;

    protected GanttListController() {
    }

    public static GanttListController create(GanttModel ganttModel) {

        if (ganttModel == null)
            return null;

        GanttListController ganttListController = new GanttListController();
        ganttListController.ganttModel = ganttModel;
        return ganttListController;
    }

    public void controll(Gantt gantt) {
        if (gantt != null) {
            String statusValue = gantt.getStatus();
            if (statusValue.equalsIgnoreCase("CREATE")) {
                addElementToStatusList(gantt);
            } else if (statusValue.equalsIgnoreCase("SCHEDULING")) {
                this.setChanged();
                notifyObservers(new GanttThreadEvent(ganttModel.listSize()));
                this.setChanged();
                notifyObservers(new GanttEventScheduling(gantt.getThreadId()));
                updateValueList(gantt, statusValue);
            }
        }
    }

    protected void updateValueList(Gantt gantt, String value) {
        for (int i = 0; i < ganttModel.listSize(); i++) {
            Gantt element = ganttModel.getElementByIndex(i);
            if (element.getThreadId() == gantt.getThreadId()) {
                ganttModel.updateElementStatus(i, value);
            }
        }
    }

    protected void addElementToStatusList(Gantt gantt) {
        ganttModel.addElement(gantt);
    }
}

