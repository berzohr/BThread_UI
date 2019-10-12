package gui.model;

import gui.model.date.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

public class ModelTest {

    private Model model;
    private Parser parser;
    private OutputProcessingThread opt;
    private ObservableList<Status> statusObservableList;
    private ObservableList<Lock> lockObservableList;
    private ObservableList<Mutex> mutexObservableList;
    private ObservableList<Semaphore> semaphoreObservableList;
    private ObservableList<Barrier> barrierObservableList;
    private ObservableList<Condition> conditionObservableList;
    protected ObservableList<Gantt> ganttList;

    @Before
    public void setUp() {
        model = Mockito.mock(Model.class);
        parser = Mockito.mock(Parser.class);
        opt = Mockito.mock(OutputProcessingThread.class);
        statusObservableList = FXCollections.observableArrayList(new ArrayList<>());
        lockObservableList = FXCollections.observableArrayList(new ArrayList<>());
        mutexObservableList = FXCollections.observableArrayList(new ArrayList<>());
        semaphoreObservableList = FXCollections.observableArrayList(new ArrayList<>());
        barrierObservableList = FXCollections.observableArrayList(new ArrayList<>());
        conditionObservableList = FXCollections.observableArrayList(new ArrayList<>());
        ganttList = FXCollections.observableArrayList(new ArrayList<>());
    }

    @Test
    public void create01() {
        assertNull(Model.create(null, opt, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList, ganttList));
    }

    @Test
    public void create02() {
        assertNull(Model.create(parser, null, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList, ganttList));
    }

    @Test
    public void create03() {
        assertNull(Model.create(parser, opt, null, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList, ganttList));
    }

    @Test
    public void create04() {
        assertNull(Model.create(parser, opt, statusObservableList, null, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList, ganttList));
    }

    @Test
    public void create05() {
        assertNull(Model.create(parser, opt, statusObservableList, lockObservableList, null, semaphoreObservableList, barrierObservableList, conditionObservableList, ganttList));
    }

    @Test
    public void create06() {
        assertNull(Model.create(parser, opt, statusObservableList, lockObservableList, mutexObservableList, null, barrierObservableList, conditionObservableList, ganttList));
    }

    @Test
    public void create07() {
        assertNull(Model.create(parser, opt, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, null, conditionObservableList, ganttList));
    }

    @Test
    public void create08() {
        assertNull(Model.create(parser, opt, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, null, ganttList));
    }

    @Test
    public void create09() {
        assertNull(Model.create(parser, opt, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList, null));
    }

    @Test
    public void create10() {
        assertNotNull(Model.create(parser, opt, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList, ganttList));
    }

    @Test
    public void startProcessTest() throws IOException {
        model.startProcess(any(Process.class), any(String.class));
        Mockito.verify(model, Mockito.times(1)).startProcess(any(Process.class), any(String.class));
    }

    @Test
    public void stopProcess() {
        model.stopProcess(any(Process.class), any(String.class));
        Mockito.verify(model, Mockito.times(1)).stopProcess(any(Process.class), any(String.class));
    }

    @Test
    public void exitProcess() {
    }

    @Test
    public void startMonitoring() {
    }

    @Test
    public void restartProcess() {
    }

    @Test
    public void pauseProcess() {
    }
}