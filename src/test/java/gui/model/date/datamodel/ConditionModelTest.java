package gui.model.date.datamodel;

import gui.model.date.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionModelTest {

    private List<Condition> conditionList;
    private ConditionModel conditionModel;

    @BeforeEach
    public void setUp() {
        conditionList = new ArrayList<>();
        conditionModel = ConditionModel.create(conditionList);
    }

    @Test
    public void create01() {
        assertNull(ConditionModel.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(conditionModel);
    }

    @Test
    public void addElement() {
        conditionModel.addElement(Mockito.mock(Condition.class));
        assertEquals(1, conditionList.size());
    }

    @Test
    public void deleteElement() {
        conditionModel.addElement(Mockito.mock(Condition.class));
        assertEquals(1, conditionList.size());

        conditionModel.deleteElement(0);
        assertEquals(0, conditionList.size());
    }

    @Test
    public void updateElementQueue() {
        Condition condition = Condition.create("(CONDBLOCKED) 3 0x1080010b0");
        conditionModel.addElement(condition);
        assertEquals(1, conditionList.size());
        assertEquals("", conditionList.get(0).getQueue());

        conditionModel.updateElementQueue(0, "2");
        assertEquals(1, conditionList.size());
        assertEquals("2", conditionList.get(0).getQueue());
    }

    @Test
    public void listSize() {
        assertEquals(conditionList.size(), conditionModel.listSize());
    }

    @Test
    public void getElementByIndex() {
        Condition condition = Mockito.mock(Condition.class);
        conditionModel.addElement(condition);
        assertEquals(condition, conditionModel.getElementByIndex(0));
    }
}