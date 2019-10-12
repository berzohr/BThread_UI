package gui.view.table;

import gui.model.date.Lock;
import gui.model.date.Semaphore;
import gui.view.JavaFXInitTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LockTableTest {

    private LockTable lockTable;
    private ObservableList<Lock> lockObservableList;

    @BeforeEach
    public void init() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        lockObservableList = FXCollections.observableArrayList(new ArrayList<>());
        lockTable = LockTable.create(lockObservableList);
    }

    @Test
    public void create01() {
        assertNull(LockTable.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(lockTable);
    }

    @Test
    public void getTableView() {
        assertEquals(lockTable.tableView, lockTable.getTableView());
    }

    public static class SemaphoreTableTest {

        private SemaphoreTable semaphoreTable;
        private ObservableList<Semaphore> observableList;

        @Before
        public void init() throws InterruptedException {
            observableList = FXCollections.observableArrayList(new ArrayList<>());
            JavaFXInitTest jinit = new JavaFXInitTest();
            jinit.init();
        }

        @org.junit.Test
        public void create01() {
            semaphoreTable = SemaphoreTable.create(null);
            assertNull(semaphoreTable);

        }

        @org.junit.Test
        public void create02() {

            semaphoreTable = SemaphoreTable.create(observableList);
            assertNotNull(semaphoreTable);
        }

        @org.junit.Test
        public void getTableView() {
            semaphoreTable = SemaphoreTable.create(observableList);
            assertEquals(semaphoreTable.getTableView(), semaphoreTable.getTableView());
        }
    }
}
