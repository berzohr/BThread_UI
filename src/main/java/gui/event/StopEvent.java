package gui.event;

import gui.style.Style;

public class StopEvent {

    private String fileName;

    public StopEvent(String fileName) {
        this.fileName = fileName;
    }

    public String getString() {
        return Style.getHour()+"[INFO]  Stop process: " + fileName;
    }
}
