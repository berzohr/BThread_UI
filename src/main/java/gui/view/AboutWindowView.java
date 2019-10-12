package gui.view;

import gui.event.AboutEvent;
import javafx.scene.control.Alert;

import java.util.Observable;
import java.util.Observer;

public class AboutWindowView implements Observer {
    final Alert dialog = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof AboutEvent) {
            dialog.setTitle("About");
            dialog.setHeaderText("CMZ Thread Execution Visualizer");
            dialog.setContentText("Authors:\n-Converso Giovanni\n-Mu Daniele Antonio\n" +
                    "-Zorloni Gabriele\n\nCopyright(c) CMZ");
            dialog.show();
        }
    }
}
