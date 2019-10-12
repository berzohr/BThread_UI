package gui.model;

import gui.event.AboutEvent;
import gui.interfaces.AboutWindowManager;

import java.util.Observable;

public class AboutWindow extends Observable implements AboutWindowManager {

    @Override
    public void aboutWindow() {
        this.setChanged();
        this.notifyObservers(new AboutEvent());
    }

}
