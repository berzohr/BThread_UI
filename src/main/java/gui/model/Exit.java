package gui.model;

import gui.event.ExitEvent;
import gui.interfaces.ExitManager;

import java.util.Observable;

public class Exit extends Observable implements ExitManager {

    @Override
    public void exitProcess() {
        this.setChanged();
        this.notifyObservers(new ExitEvent());
    }
}
