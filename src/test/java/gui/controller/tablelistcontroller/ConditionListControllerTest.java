package gui.controller.tablelistcontroller;

import gui.model.date.Condition;
import gui.model.date.datamodel.ConditionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionListControllerTest {

    private ObservableList<Condition> conditionObservableList;
    private ConditionModel conditionModel;
    private ConditionListController conditionListController;

    @BeforeEach
    public void setUp() {
        conditionObservableList = FXCollections.observableArrayList(new ArrayList<>());
        conditionModel = ConditionModel.create(conditionObservableList);
        conditionListController = Mockito.spy(ConditionListController.create(conditionModel));
        Mockito.doNothing().when(conditionListController).reloadData();
    }

    @Test
    public void create01() {
        assertNull(ConditionListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(conditionListController);
    }

    @Test
    public void controll01() {
        Condition condition = Condition.create("(CONDSIGNAL) 2 0x10f8760b8");
        conditionListController.controll(condition);
        Mockito.verify(conditionListController, Mockito.times(1)).condsignalFunction(condition);
    }

    @Test
    public void controll02() {
        Condition condition = Condition.create("(CONDBROADCAST) 2 0x10f8760b0");
        conditionListController.controll(condition);
        Mockito.verify(conditionListController, Mockito.times(1)).condbroadcastFunction(condition);
    }

    @Test
    public void controll03() {
        Condition condition = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController.controll(condition);
        Mockito.verify(conditionListController, Mockito.times(1)).condblockedFunction(condition);
    }

    @Test
    void condblockedFunction01() {
        Condition condition = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController.condblockedFunction(condition);
        assertEquals("2", conditionModel.getElementByIndex(0).getQueue());
    }

    @Test
    void condblockedFunction02() {
        Condition condition1 = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController.condblockedFunction(condition1);
        assertEquals("2", conditionModel.getElementByIndex(0).getQueue());

        Condition condition2 = Condition.create("(CONDBLOCKED) 3 0x10f8760b0");
        conditionListController.condblockedFunction(condition2);
        assertEquals("2 , 3", conditionModel.getElementByIndex(0).getQueue());
    }

    @Test
    void condbroadcastFunction() {
        Condition condition1 = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController.condblockedFunction(condition1);
        assertEquals("2", conditionModel.getElementByIndex(0).getQueue());

        Condition condition2 = Condition.create("(CONDBROADCAST) 2 0x10f8760b0");
        conditionListController.condbroadcastFunction(condition2);
        assertNull(conditionModel.getElementByIndex(0).getQueue());
    }

    @Test
    void condsignalFunction() {
        Condition condition1 = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController.condblockedFunction(condition1);
        assertEquals("2", conditionModel.getElementByIndex(0).getQueue());

        Condition condition2 = Condition.create("(CONDBLOCKED) 3 0x10f8760b0");
        conditionListController.condblockedFunction(condition2);
        assertEquals("2 , 3", conditionModel.getElementByIndex(0).getQueue());

        Condition condition3 = Condition.create("(CONDSIGNAL) 2 0x10f8760b0");
        conditionListController.condsignalFunction(condition3);
        assertEquals("3", conditionModel.getElementByIndex(0).getQueue());
    }
}