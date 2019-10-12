package gui.event;

import gui.style.Style;

public class StartEvent {

    private String fileName;

    public StartEvent(String fileName) {
        this.fileName = fileName;
    }

    public String getString() {
        return Style.getHour() + "[INFO]  Start process: " + fileName;
    }
}
