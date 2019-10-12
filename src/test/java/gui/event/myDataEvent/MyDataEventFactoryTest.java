package gui.event.myDataEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyDataEventFactoryTest {

    private MutexEvent mutexEvent;

    @BeforeEach
    void setUp() {
        mutexEvent = (MutexEvent) MyDataEventFactory.create("MutexEvent", "(MUTEX) 1 0x623747");
    }

    @Test
    public void create01() {
        assertNull(MyDataEventFactory.create(null, "(MUTEX) 1 0x623747"));
    }

    @Test
    public void create02() {
        assertNull(MyDataEventFactory.create("MutexEvent", null));
    }

    @Test
    public void create03() {
        assertNotNull(mutexEvent);
    }

    @Test
    public void create04() {
        //MyDataEventFactory.create("execption", anyString());
    }

}