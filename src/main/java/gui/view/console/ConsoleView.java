package gui.view.console;

import gui.event.*;
import gui.style.Style;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.util.Observable;
import java.util.Observer;

public class ConsoleView implements Observer {
    protected TextArea console;

    protected ConsoleView() {
    }

    public static ConsoleView create() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.console = new TextArea();
        consoleView.console.setEditable(false);
        consoleView.console.setPrefRowCount(10);
        consoleView.console.getStyleClass().add("console");
        consoleView.console.getStylesheets().add(Style.getCSS());
        return consoleView;
    }

    public TextArea getConsole() {
        return console;
    }

    public void clearConsole() {
        console.clear();
    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof StartEvent) {
            clearConsole();
            console.appendText(((StartEvent) event).getString() + "\n");
        } else if (event instanceof PauseEvent) {
            console.appendText(((PauseEvent) event).getString() + "\n");
        } else if (event instanceof StopEvent) {
            console.appendText(((StopEvent) event).getString() + "\n");
        } else if (event instanceof ExitEvent) {
            console.appendText(((ExitEvent) event).getString() + "\n");
        } else if (event instanceof ChooseFileEvent) {
            console.appendText(((ChooseFileEvent) event).getString() + "\n");
        } else if (event instanceof RestartEvent) {
            clearConsole();
            console.appendText(((RestartEvent) event).getString() + "\n");
        } else if (event instanceof NewLineReadEvent) {
            Platform.runLater(() -> console.appendText(((NewLineReadEvent) event).getLine()));
        }
    }
}
