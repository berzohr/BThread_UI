package gui.event;

import gui.style.Style;

public class NewLineReadEvent {

    private String line;

    public NewLineReadEvent(String line) {
        this.line = line;
    }

    public String getLine() {
        return Style.getHour() + "[MONITORING] " + line;
    }
}
