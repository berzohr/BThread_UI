package gui.view.table;

import gui.model.date.Semaphore;
import gui.view.JavaFXInitTest;
import gui.view.table.MutexTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MutexTableTest {

    private MutexTable mutexTable;
    private ObservableList<Semaphore> observableList;

    @Before
    public void init() throws InterruptedException {
        observableList = FXCollections.observableArrayList(new ArrayList<>());
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
    }

    @Test
    public void create01() {
        mutexTable = MutexTable.create(null);
        assertNull(mutexTable);
    }

    @Test
    public void create02() {
        mutexTable = MutexTable.create(observableList);
        assertNotNull(mutexTable);
    }

    @Test
    public void getTableView(){
        mutexTable = MutexTable.create(observableList);
        assertEquals(mutexTable.getTableView(), mutexTable.getTableView());
    }
}