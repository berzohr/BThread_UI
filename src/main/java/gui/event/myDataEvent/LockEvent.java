package gui.event.myDataEvent;

import gui.model.date.MyDataFactory;


public class LockEvent extends MyDataEvent {

    protected LockEvent() {
    }

    public static MyDataEvent create(String line) {

        if (line == null)
            return null;

        MyDataEvent lockEvent = new LockEvent();
        lockEvent.data = MyDataFactory.create("Lock", line);

        return lockEvent;
    }

}