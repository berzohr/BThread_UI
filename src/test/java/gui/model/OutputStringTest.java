package gui.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OutputStringTest {

    private OutputString outputString;

    @BeforeEach
    public void setUp() {
        outputString = new OutputString("parma1", "param2", "param3");
    }

    @Test
    public void create01() {
        assertNotNull(outputString);
    }

    @Test
    public void getParam1() {
        assertEquals(outputString.param1, outputString.getParam1());
    }

    @Test
    public void getParam2() {
        assertEquals(outputString.param2, outputString.getParam2());
    }

    @Test
    public void getParam3() {
        assertEquals(outputString.param3, outputString.getParam3());
    }
}