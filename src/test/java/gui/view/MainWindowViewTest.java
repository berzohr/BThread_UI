package gui.view;

import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;


public class MainWindowViewTest {

    MainWindowView interfaceBthread;
    Stage stage;

    @Before
    public void setUp() throws Exception {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        interfaceBthread = MainWindowView.getInstance();
        stage = Mockito.mock(Stage.class);
    }

    @Test
    public void showInterface() {

    }

    @Test
    public void getInstance() {
        assertEquals(MainWindowView.ourInstance, MainWindowView.getInstance());
    }

    @Test
    public void getObserverList() {
    }
}