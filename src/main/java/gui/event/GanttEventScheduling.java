package gui.event;

public class GanttEventScheduling {

    protected int threadNumber;

    public GanttEventScheduling(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public int getThreadNumber() {
        return threadNumber;
    }
}
