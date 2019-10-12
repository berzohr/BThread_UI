package gui.event;

import gui.style.Style;

public class AboutEvent {
    public String getString() {
        return Style.getHour() + "[INFO] Open About Window\n";
    }
}
