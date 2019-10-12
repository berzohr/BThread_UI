
import gui.view.MainWindowView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainWindowView interfaceBthread = MainWindowView.getInstance();
        interfaceBthread.showInterface(primaryStage);
    }
}