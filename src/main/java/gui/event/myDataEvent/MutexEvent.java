package gui.event.myDataEvent;

import gui.model.date.MyDataFactory;

public class MutexEvent extends MyDataEvent {

    protected MutexEvent() {
    }

    public static MutexEvent create(String line) {

        if (line == null)
            return null;

        MutexEvent mutexEvent = new MutexEvent();
        //mutexEvent.mutex = Mutex.create(line);
        mutexEvent.data = MyDataFactory.create("Mutex", line);

        return mutexEvent;
    }
}
