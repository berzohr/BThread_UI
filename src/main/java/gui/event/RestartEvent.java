package gui.event;

import gui.style.Style;

public class RestartEvent {

    private String fileName;

    public RestartEvent(String fileName) {
        this.fileName = fileName;
    }

    public String getString() {
        return Style.getHour() + "[INFO]  Restart process: " + fileName;
    }
}
