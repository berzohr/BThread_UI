package gui.model;

import gui.model.date.MyData;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MyDataTest {

    @Mock
    private MyData myData;

    @BeforeEach
    public void setUp() {
        myData = Mockito.mock(MyData.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void getStatus() {
        //assertEquals(myData.status, myData.getStatus());
    }

    @Test
    public void getAddress() {
        //assertEquals(myData.address, myData.getAddress());
    }
}