package gui.view.table;

import gui.model.date.Barrier;
import gui.view.JavaFXInitTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BarrierTableTest {

    private BarrierTable barrierTable;
    private ObservableList<Barrier> barrierObservableList;

    @BeforeEach
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        barrierObservableList = FXCollections.observableArrayList(new ArrayList<>());
        barrierTable = BarrierTable.create(barrierObservableList);
    }

    @Test
    public void create01() {
        assertNull(BarrierTable.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(barrierTable);
    }

    @Test
    public void getTableView() {
        assertEquals(barrierTable.tableView, barrierTable.getTableView());
    }
}