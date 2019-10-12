package gui.event.myDataEvent;

import gui.model.date.MyDataFactory;

public class SemaphoreEvent extends MyDataEvent {

    public static SemaphoreEvent create(String line) {

        if (line == null)
            return null;

        SemaphoreEvent semaphoreEvent = new SemaphoreEvent();
        //semaphoreEvent.semaphore = Semaphore.create(line);
        semaphoreEvent.data = MyDataFactory.create("Semaphore", line);
        return semaphoreEvent;
    }
}
