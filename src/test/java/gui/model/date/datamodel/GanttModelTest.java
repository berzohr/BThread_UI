package gui.model.date.datamodel;

import gui.model.date.Gantt;
import javafx.collections.FXCollections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GanttModelTest {

    private List<Gantt> ganttList;
    private GanttModel ganttModel;

    @BeforeEach
    public void setUp() {
        ganttList = FXCollections.observableArrayList(new ArrayList<>());
        ganttModel = GanttModel.create(ganttList);
    }

    @Test
    public void create01() {
        assertNull(GanttModel.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(ganttModel);
    }

    @Test
    public void addElement() {
        ganttModel.addElement(Mockito.mock(Gantt.class));
        assertEquals(1, ganttList.size());
    }

    @Test
    public void updateElementStatus() {
        Gantt gantt = Gantt.create("(CREATE) 1");
        ganttModel.addElement(gantt);
        assertEquals(1, ganttList.size());
        assertEquals("CREATE", ganttList.get(0).getStatus());

        ganttModel.updateElementStatus(0, "SCHEDULING");
        assertEquals(1, ganttList.size());
        assertEquals("SCHEDULING", ganttList.get(0).getStatus());
    }

    @Test
    public void listSize() {
        assertEquals(ganttList.size(), ganttModel.listSize());
    }

    @Test
    public void getElementByIndex() {
        Gantt gantt = Mockito.mock(Gantt.class);
        ganttModel.addElement(gantt);
        assertEquals(gantt, ganttModel.getElementByIndex(0));
    }
}