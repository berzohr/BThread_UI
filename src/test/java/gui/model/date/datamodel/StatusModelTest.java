package gui.model.date.datamodel;

import gui.model.date.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StatusModelTest {

    private List<Status> statusList;
    private StatusModel statusModel;

    @BeforeEach
    public void setUp() {
        statusList = new ArrayList<>();
        statusModel = StatusModel.create(statusList);
    }

    @Test
    public void create01() {
        assertNull(StatusModel.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(statusModel);
    }

    @Test
    public void addElement() {
        statusModel.addElement(Mockito.mock(Status.class));
        assertEquals(1, statusList.size());
    }

    @Test
    public void deleteElement() {
        statusModel.addElement(Mockito.mock(Status.class));
        assertEquals(1, statusList.size());

        statusModel.deleteElement(0);
        assertEquals(0, statusList.size());
    }

    @Test
    public void updateElementStatus() {
        Status status = Status.create("(SCHEDULING) 1");
        statusModel.addElement(status);
        assertEquals(1, statusList.size());
        assertEquals("SCHEDULING", statusList.get(0).getStatus());

        statusModel.updateElementStatus(0, "RUNNING");
        assertEquals(1, statusList.size());
        assertEquals("RUNNING", statusList.get(0).getStatus());
    }

    @Test
    public void listSize() {
        assertEquals(statusList.size(), statusModel.listSize());
    }

    @Test
    public void getElementByIndex() {
        Status status = Mockito.mock(Status.class);
        statusModel.addElement(status);
        assertEquals(status, statusModel.getElementByIndex(0));
    }
}