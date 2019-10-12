package gui.view.table;

import gui.model.date.Condition;
import gui.view.JavaFXInitTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionTableTest {

    private ConditionTable conditionTable;
    private ObservableList<Condition> conditionObservableList;

    @BeforeEach
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        conditionObservableList = FXCollections.observableArrayList(new ArrayList<>());
        conditionTable = ConditionTable.create(conditionObservableList);
    }

    @Test
    public void create01() {
        assertNull(ConditionTable.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(conditionTable);
    }

    @Test
    public void getTableView() {
        assertEquals(conditionTable.tableView, conditionTable.getTableView());
    }
}