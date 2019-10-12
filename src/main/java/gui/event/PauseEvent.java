package gui.event;

public class PauseEvent {

    private String fileName;

    public PauseEvent(String fileName) {
        this.fileName = fileName;
    }

    public String getString() {
        return "Pause process: " + fileName;
    }
}
