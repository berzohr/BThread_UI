package gui.view.table;

import gui.model.date.Status;
import gui.view.JavaFXInitTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class StatusTableTest {

    private StatusTable statusTable;
    private ObservableList<Status> statusObservableList;

    @BeforeEach
    void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        statusObservableList = FXCollections.observableArrayList(new ArrayList<>());
        statusTable = StatusTable.create(statusObservableList);
    }

    @Test
    void create01() {
        assertNull(StatusTable.create(null));
    }

    @Test
    void create02() {
        assertNotNull(statusTable);
    }

    @Test
    void getTableView() {
        assertEquals(statusTable.tableView, statusTable.getTableView());
    }
}