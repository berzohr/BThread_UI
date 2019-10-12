package gui.view.ganttchart;

import gui.view.JavaFXInitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class GantChartInitializeTest {

    private GantChartInitialize gantChartInitialize;

    @BeforeEach
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        gantChartInitialize = GantChartInitialize.create();
    }

    @Test
    public void create() {
        assertNotNull(gantChartInitialize);
    }

    @Test
    public void init() {

    }

    @Test
    public void update() {
    }

    @Test
    public void getChart() {
        assertEquals(gantChartInitialize.chart, gantChartInitialize.getChart());
    }

}